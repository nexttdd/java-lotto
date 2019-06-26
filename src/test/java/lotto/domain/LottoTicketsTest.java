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
        String[] numbers = {"1", "2", "7", "4", "5", "6" };

        tickets = new ArrayList<>();
        tickets.add(new LottoTicket(numbers));
    }

    @Test
    public void 로또티켓들_생성하기() {
        //when
        LottoTickets lottoTickets = new LottoTickets(tickets);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(1);
    }

    @Test
    public void 로또티켓_추가하기() {
        //given
        LottoTickets lottoTickets = new LottoTickets(tickets);
        LottoTickets secondTickets = new LottoTickets(tickets);

        //when
        lottoTickets.addAll(secondTickets);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(2);
    }
}
