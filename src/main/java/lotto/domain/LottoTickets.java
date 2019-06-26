package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public Ranks matchLuckyNumber(LottoTicket luckyLotto) {
        Ranks ranks = new Ranks();

        for (LottoTicket lottoTicket : tickets) {
            ranks.addMatchTicket(lottoTicket.matchLuckyNumber(luckyLotto),
                    lottoTicket.matchBonusNumber(luckyLotto));
        }

        return ranks;
    }

    public LottoTickets addAll(LottoTickets tickets) {
        this.tickets.addAll(tickets.getTickets());
        return this;
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
}