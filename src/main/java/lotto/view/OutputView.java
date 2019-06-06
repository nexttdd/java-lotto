package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class OutputView {
    public static void printTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getTickets()) {
            System.out.println(lottoTicket.toString());
        }
        System.out.println();
    }
}