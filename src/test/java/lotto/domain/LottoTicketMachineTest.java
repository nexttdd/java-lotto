package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketMachineTest {

    @Test
    public void 로또티켓_자동1장_발급하기() {
        //given
        LottoMoney lottoMoney = new LottoMoney(1000);

        //when
        LottoTickets lottoTickets = LottoTicketMachine.issueTickets(lottoMoney, null);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(1);
    }

    @Test
    public void 수동_n장_발급하기() {
        //given
        String[] manualNumbers = {"1,2,3,4,5,6", "11,12,13,14,15,16"};

        //when
        LottoTickets lottoTickets = LottoTicketMachine.issueManualTickets(manualNumbers);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(2);
    }

    @Test
    public void 로또티켓_수동1장_자동2장_발급하기() {
        //given
        LottoMoney lottoMoney = new LottoMoney(3000);
        lottoMoney.buyManualTicket(1);
        String[] manualNumbers = {"1,2,3,4,5,6"};

        //when
        LottoTickets lottoTickets = LottoTicketMachine.issueTickets(lottoMoney, manualNumbers);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(3);
    }
}