package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private List<LottoNumber> numbers;
    private LottoNumber bonusNumber;
    private boolean isBonusMatch;

    public LottoTicket(List<LottoNumber> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public LottoTicket(String[] ticketNumbers) {
        numbers = Arrays.stream(ticketNumbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket(String[] ticketNumbers, String bonusNumber) {
        checkArguments(ticketNumbers, bonusNumber);

        this.numbers = Arrays.stream(ticketNumbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
    }

    private void checkArguments(String[] ticketNumbers, String bonusNumber) {
        if (ticketNumbers.length < 6) {
            throw new IllegalArgumentException("지난주 당첨번호 입력이 잘못됐습니다.");
        }

        if ("".equals(bonusNumber.trim())) {
            throw new IllegalArgumentException("보너스 볼이 없습니다.");
        }

        List<String> lottoNumbers = Arrays.asList(ticketNumbers);
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 중복됩니다.");
        }
    }

    int matchLuckyNumber(LottoTicket luckyLotto) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : numbers) {
            matchCount = lottoNumber.countMatchNumber(luckyLotto, matchCount);
        }

        return matchCount;
    }

    public boolean matchBonusNumber(LottoTicket luckyLotto) {
        for (LottoNumber lottoNumber : numbers) {
            isBonusMatch = lottoNumber.isBonusNumber(luckyLotto.getBonusNumber(), this.isBonusMatch);
        }

        return this.isBonusMatch;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
