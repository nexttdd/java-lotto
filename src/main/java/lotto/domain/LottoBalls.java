package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBalls {
    private static final List<Integer> balls;

    static {
        balls = new ArrayList<>();
        for (int i = Const.MIN_NUMBER; i <= Const.MAX_NUMBER; i++) {
            balls.add(i);
        }
    }

    public static List<LottoNumber> extractNumbers(int numberOfBalls) {
        shuffle();

        return balls.subList(0, numberOfBalls).stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void shuffle() {
        Collections.shuffle(balls);
    }

    public static List<Integer> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}