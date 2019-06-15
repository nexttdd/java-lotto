package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    public void run() {
        LottoMoney lottoMoney = InputView.inputMoney();

        LottoTickets lottoTickets = issueTickets(lottoMoney);

        LottoTicket luckyLotto = InputView.inputLuckyLotto();

        Ranks ranks = matchLuckyNumber(luckyLotto, lottoTickets);
        OutputView.printRanks(ranks);

        double profit = ranks.calculateProfit(lottoMoney.getMoney());
        OutputView.printProfit(profit);
    }

    private Ranks matchLuckyNumber(LottoTicket luckyLotto, LottoTickets lottoTickets) {
        return lottoTickets.matchLuckyNumber(luckyLotto);
    }

    private LottoTickets issueTickets(LottoMoney lottoMoney) {
        LottoTickets lottoTickets = LottoTicketMachine.issueTickets(lottoMoney.getTicketCount());
        OutputView.printTickets(lottoTickets);

        return lottoTickets;
    }
}