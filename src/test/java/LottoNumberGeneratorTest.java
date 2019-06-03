import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {
    //TODO : 랜덤으로 숫자 섞기
    //TODO : 6개 숫자 추출하기

    @Test
    public void 로또한장_발급하기() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<Integer> lottoTicket = lottoNumberGenerator.issueOneTicket();
        System.out.println(lottoTicket.toString());
        assertThat(lottoTicket.size()).isEqualTo(6);
    }
}
