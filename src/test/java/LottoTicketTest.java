import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    public void 로또티켓만들기() {
        //given
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(6), new LottoNumber(5), new LottoNumber(4)
                ,new LottoNumber(3), new LottoNumber(2), new LottoNumber(1));

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }
}
