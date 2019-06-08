package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public Ranks matchLuckyNumber(LottoTicket luckyLotto) {
        Ranks ranks = new Ranks();

        for (LottoTicket lottoTicket : tickets) {
            ranks.addMatchTicket(lottoTicket.matchLuckyNumber(luckyLotto));
        }

        return ranks;
    }
}