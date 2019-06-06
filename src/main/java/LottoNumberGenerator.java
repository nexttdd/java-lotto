import java.util.List;

public class LottoNumberGenerator {
    private static final int NUMBER_OF_BALLS = 6;

    public static LottoTicket generateOneTicket() {
        List<LottoNumber> lottoNumbers = LottoBalls.extractNumbers(NUMBER_OF_BALLS);
        return new LottoTicket(lottoNumbers);
    }
}
