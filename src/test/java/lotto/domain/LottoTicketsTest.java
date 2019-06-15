package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private List<LottoTicket> tickets;

    @Before
    public void setUp() throws Exception {
        //given
        tickets = new ArrayList<>();
        tickets.add(LottoTicketMachine.issueOneTicket());
    }

    @Test
    public void 로또티켓들_생성하기() {
        //when
        LottoTickets lottoTickets = new LottoTickets(tickets);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(1);
    }
}
