package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(String[] ticketNumbers) {
        numbers = new ArrayList<>();

        for (String number : ticketNumbers) {
            numbers.add(new LottoNumber(Integer.parseInt(number)));
        }
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
