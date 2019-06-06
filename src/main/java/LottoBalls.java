import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBalls {
    public static final List<Integer> balls;

    static {
        balls = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            balls.add(i);
        }
    }

    public static List<LottoNumber> extractNumbers(int numberOfBalls) {
        shuffle();

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfBalls; i++) {
            lottoNumbers.add(new LottoNumber(balls.get(i)));
        }

        return sort(lottoNumbers);
    }

    private static void shuffle() {
        Collections.shuffle(balls);
    }

    private static List<LottoNumber> sort(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}