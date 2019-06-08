package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    public void run() {
        LottoMoney lottoMoney = InputView.inputMoney();

        LottoTickets lottoTickets = issueTickets(lottoMoney);

        //TODO : 지난주 당첨번호 입력받고
        LottoTicket luckyLotto = InputView.inputLuckyLotto();

        //TODO : 당첨통계 구하기
        Ranks ranks = matchLuckyNumber(luckyLotto, lottoTickets);
        OutputView.printRanks(ranks);

        //TODO : 수익률 구하기
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