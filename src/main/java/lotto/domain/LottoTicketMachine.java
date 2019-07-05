package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {

    public static LottoTickets issueTickets(LottoMoney lottoMoney, String[] manualNumbers) {
        if (lottoMoney.isNeedManualTicket()) {
            LottoTickets lottoTickets = issueManualTickets(manualNumbers);
            return lottoTickets.addAll(issueAutoTickets(lottoMoney.getAutoTicketCount()));
        }

        return issueAutoTickets(lottoMoney.getAutoTicketCount());
    }

    private static LottoTickets issueAutoTickets(int numberOfTickets) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(new LottoTicket(LottoBalls.extractNumbers(Const.NUMBER_OF_BALLS)));
        }

        return new LottoTickets(tickets);
    }

    public static LottoTickets issueManualTickets(String[] numbers) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (String number : numbers) {
            tickets.add(issueOneTicket(number));
        }

        return new LottoTickets(tickets);
    }

    private static LottoTicket issueOneTicket(String numbers) {
        return new LottoTicket(splitNumbers(numbers));
    }

    private static String[] splitNumbers(String numbers) {
        return numbers.split(",| ");
    }
}
