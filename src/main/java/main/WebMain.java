package main;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import vo.*;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class WebMain {
    public static Lottos lottos = new Lottos();

    public static void main(String[] args) {
        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/templates"); // Static files


        post("/buyLotto", (req, res) -> {
            String paramMoney = req.queryParams("inputMoney");

            System.out.println(paramMoney + "===================");
            Money money = new Money(paramMoney);

//            List<Lotto> manualLottos = inputView.manualLottoNumbers(manualCount);
//            resultView.printPurchaseTicketCount(manualCount, money.getExceptManualCount(manualCount));

            lottos = LottoGenerator.generateByMoney(money, null);
            System.out.println(lottos);

            Map<String, Object> model = new HashMap<>();
            model.put("lottoSize", lottos.count());
            model.put("lottos", lottos.toString());
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            WinningLotto winningLotto = new WinningLotto(Lotto.of(winningNumber), LottoNumber.of(bonusNumber));
            MatchingResults result = lottos.match(winningLotto);

            System.out.println("===========result: "+result.getResults().get(0).getDisplayText());
            Map<String, Object> model = new HashMap<>();
            model.put("six", result.getResults().get(0));
            return render(null, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
