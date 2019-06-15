package lotto.domain;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallsTest {
    @Test
    public void 로또45개숫자확인() {
        int idx = 1;

        //given, when, then
        for (Integer ball : LottoBalls.getBalls()) {
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

    @Test
    public void 중복검사() {
        Set<Integer> lottoSet = new HashSet<>(LottoBalls.getBalls());

        assertThat(lottoSet.size()).isEqualTo(LottoBalls.getBallsSize());
    }
}