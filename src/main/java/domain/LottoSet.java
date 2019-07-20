package domain;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public final class LottoSet {
    public static final int LOTTO_SIZE = 6;
    private final SortedSet<LottoNumber> lottoNumbers;

    private LottoSet(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 갯수를 바르게 입력해주세요");
        }

        this.lottoNumbers = new TreeSet<>(lottoNumbers);

        if (this.lottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public static LottoSet newInstance(List<LottoNumber> lottoNumbers) {
        return new LottoSet(lottoNumbers);
    }

    public static LottoSet newInstance(int... lottoNumbers) {
        return new LottoSet((Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList())));
    }

    public int countOfMatchNumber(LottoSet winningLotto) {
        return (int) winningLotto.lottoNumbers.stream()
                .filter(this::isMatchNumber)
                .count();
    }

    public boolean isMatchNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public SortedSet<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
