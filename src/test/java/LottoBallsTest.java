import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallsTest {
    @Test
    public void 로또45개숫자확인() {
        int idx = 1;
        for (Integer ball : LottoBalls.balls) {
            assertThat(ball).isEqualTo(idx++);
        }
    }

    @Test
    public void 로또번호6개추출() {
        int numberOfBalls = 6;
        List<Integer> balls = LottoBalls.extractBalls(numberOfBalls);
        assertThat(balls.size()).isEqualTo(6);

        for (int i = 0; i < 6; i++) {
            assertThat(balls.get(i)).isEqualTo(i+1);
        }
    }
}