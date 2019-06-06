import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
