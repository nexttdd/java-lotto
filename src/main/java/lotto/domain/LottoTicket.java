package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(String[] ticketNumbers) {
        numbers = Arrays.stream(ticketNumbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int matchLuckyNumber(LottoTicket luckyLotto) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : numbers) {
            matchCount += lottoNumber.countMatchNumber(luckyLotto);
        }

        return matchCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
