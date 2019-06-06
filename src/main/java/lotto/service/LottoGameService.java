package lotto.service;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    public void run() {
        LottoMoney lottoMoney = InputView.inputMoney();

        LottoTickets lottoTickets = issueTickets(lottoMoney);

        //TODO : 지난주 당첨번호 입력받고
        LottoTicket luckeyLotto = InputView.inputLuckyLotto();

        //TODO : 당첨통계 구하기
    }

    private LottoTickets issueTickets(LottoMoney lottoMoney) {
        LottoTickets lottoTickets = LottoTicketMachine.issueTickets(lottoMoney.getTicketCount());
        OutputView.printTickets(lottoTickets);

        return lottoTickets;
    }
}
