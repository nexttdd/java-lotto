package lotto;

import lotto.domain.*;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class LottoWebMain {

    public static void main(String[] args) {
        Spark.staticFiles.location("templates");
        port(4567);
        index();
        buyLotto();
        matchLotto();
    }

    private static void index() {
        get("/", (req, res) -> {
            return render(null, "index.html");
        });
    }

    private static void buyLotto() {
        post("/buyLotto", (req, res) -> {
            String inputMoney = req.queryParams("inputMoney");
            String[] manualNumber = req.queryParams("manualNumber").split("\r\n");

            LottoMoney lottoMoney = new LottoMoney(Long.parseLong(inputMoney));
            lottoMoney.buyManualTicket(manualNumber);
            LottoTickets lottoTickets = LottoTicketMachine.issueTickets(lottoMoney, manualNumber);

            req.session().attribute("lottoTickets", lottoTickets);
            req.session().attribute("lottoMoney", lottoMoney);

            Map<String, Object> model = new HashMap<>();
            model.put("ticketCount", lottoMoney.getAutoTicketCount() + lottoMoney.getManualTicketCount());
            model.put("lottoTickets", lottoTickets.getTickets());

            return render(model, "show.html");
        });
    }

    private static void matchLotto() {
        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            LottoTicket luckyLotto = new LottoTicket(winningNumber.split(",| "), bonusNumber);
            LottoTickets lottoTickets = req.session().attribute("lottoTickets");
            LottoMoney lottoMoney = req.session().attribute("lottoMoney");

            Ranks ranks = lottoTickets.matchLuckyNumber(luckyLotto);
            String profit = ranks.calculateProfit(lottoMoney.getMoney());

            Map<String, Object> model = new HashMap<>();
            ResultViewDto dto = ResultViewDto.of(ranks);

            model.put("ranks", dto.getResult());
            model.put("profit", profit);

            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
