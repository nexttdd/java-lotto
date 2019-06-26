package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    public void run() {
        LottoMoney lottoMoney = InputView.inputMoney();

        LottoTickets lottoTickets = issueTickets(lottoMoney, InputView.buyManualTickets(lottoMoney));

        LottoTicket luckyLotto = InputView.inputLuckyLotto();

        Ranks ranks = matchLuckyNumber(luckyLotto, lottoTickets);
        OutputView.printRanks(ranks);

        String profit = ranks.calculateProfit(lottoMoney.getMoney());
        OutputView.printProfit(profit);
    }

    private LottoTickets issueTickets(LottoMoney lottoMoney, String[] manualNumbers) {
        LottoTickets lottoTickets = LottoTicketMachine.issueTickets(lottoMoney, manualNumbers);
        OutputView.printTickets(lottoMoney, lottoTickets);

        return lottoTickets;
    }

    private Ranks matchLuckyNumber(LottoTicket luckyLotto, LottoTickets lottoTickets) {
        return lottoTickets.matchLuckyNumber(luckyLotto);
    }
}