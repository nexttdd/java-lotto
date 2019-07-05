package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int number) {
        checkOutOfRange(number);
        this.number = number;
    }

    private void checkOutOfRange(int number) {
        if (Const.MIN_NUMBER > number || Const.MAX_NUMBER < number) {
            throw new IllegalArgumentException("outOfRange. check Number : " + number);
        }
    }

    public int countMatchNumber(LottoTicket luckyLotto, int matchCount) {
        boolean isMatch = Boolean.FALSE;

        for (LottoNumber luckyNumber : luckyLotto.getNumbers()) {
            isMatch = luckyNumber.isMatch(number, isMatch);
        }

        return Boolean.TRUE == isMatch ? matchCount + 1 : matchCount;
    }

    private boolean isMatch(int lottoNumber, boolean isMatch) {
        return Boolean.TRUE == isMatch ? Boolean.TRUE : this.number == lottoNumber;
    }

    public boolean isBonusNumber(LottoNumber bonusNumber, boolean isBonusMatch) {
        return Boolean.TRUE == isBonusMatch ? Boolean.TRUE : this.number == bonusNumber.number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);

    }
}
