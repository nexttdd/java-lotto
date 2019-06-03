import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int NUMBER_OF_BALLS = 6;

    public List<Integer> issueOneTicket() {
        Collections.shuffle(LottoBalls.balls);

        List<Integer> lottoNumbers = LottoBalls.extractBalls(NUMBER_OF_BALLS);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
