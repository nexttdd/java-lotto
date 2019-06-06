import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallsTest {
    @Test
    public void 로또45개숫자확인() {
        int idx = 1;

        //given, when, then
        for (Integer ball : LottoBalls.balls) {
            assertThat(ball).isEqualTo(idx++);
        }
    }

    @Test
    public void 로또번호_6개추출하기() {
        //given
        int numberOfBalls = 6;

        //when
        List<LottoNumber> lottoNumbers = LottoBalls.extractNumbers(numberOfBalls);

        //then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}