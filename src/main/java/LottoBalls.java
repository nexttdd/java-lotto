import java.util.ArrayList;
import java.util.List;

public class LottoBalls {
    public static final List<Integer> balls;
    static {
        balls = new ArrayList<>();
        for (int i=1 ; i < 46 ; i++) {
            balls.add(i);
        }
    }

    public static List<Integer> extractBalls(int numberOfBalls) {
        List<Integer> lottoBalls = new ArrayList<>();
        for (int i = 0 ; i < numberOfBalls ; i++) {
            lottoBalls.add(balls.get(i));
        }
        return lottoBalls;
    }
}