import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void 로또티켓_한장_발급하기() {
        //when
        LottoTicket lottoTicket = LottoNumberGenerator.generateOneTicket();

        //then
        System.out.println(lottoTicket.toString());
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 로또티켓_n장_발급하기() {
        //given
        int numberOfTickets = 5;

        //when
        LottoTickets lottoTickets = LottoNumberGenerator.generateTickets(numberOfTickets);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(numberOfTickets);
    }
}