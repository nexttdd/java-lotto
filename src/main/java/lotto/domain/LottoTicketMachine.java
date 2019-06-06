package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {
    private static final int NUMBER_OF_BALLS = 6;

    public static LottoTicket issueOneTicket() {
        List<LottoNumber> lottoNumbers = LottoBalls.extractNumbers(NUMBER_OF_BALLS);
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTickets issueTickets(int numberOfTickets) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(issueOneTicket());
        }

        return new LottoTickets(tickets);
    }

    public static LottoTicket issueOneTicket(String[] numbers) {
        return new LottoTicket(numbers);
    }
}
