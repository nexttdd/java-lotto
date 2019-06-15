package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int number) {
        checkOutOfRange(number);
        this.number = number;
    }

    private boolean checkOutOfRange(int number) {
        if (LottoBalls.MIN_NUMBER > number || LottoBalls.MAX_NUMBER < number) {
            throw new IllegalArgumentException();
        }
        return true;
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
        if (this.number < o.number) {
            return -1;
        }

        if (this.number > o.number) {
            return 1;
        }

        return 0;
    }

    public int countMatchNumber(LottoTicket luckyLotto) {

        for (LottoNumber luckyNumber : luckyLotto.getNumbers()) {
            if (luckyNumber.isMatch(number)) {
                return 1;
            }
        }

        return 0;
    }

    private boolean isMatch(int lottoNumber) {
        return this.number == lottoNumber;
    }
}
