package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketMachineTest {

    @Test
    public void 로또티켓_한장_발급하기() {
        //when
        LottoTicket lottoTicket = LottoTicketMachine.issueOneTicket();

        //then
        System.out.println(lottoTicket.toString());
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 로또티켓_n장_발급하기() {
        //given
        int numberOfTickets = 5;

        //when
        LottoTickets lottoTickets = LottoTicketMachine.issueTickets(numberOfTickets);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(numberOfTickets);
    }
}