import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void 로또티켓_한장_발급하기() {
        //given, when
        LottoTicket lottoTicket = LottoNumberGenerator.generateOneTicket();

        //then
        System.out.println(lottoTicket.toString());
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }
}
