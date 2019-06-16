package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoNumberTests {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호는_최대값보다_클_수_없다() {
        new LottoNumber(LottoNumber.LOTTO_MAX_NUMBER + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호는_최소값보다_작을_수_없다() {
        new LottoNumber(LottoNumber.LOTTO_MIN_NUMBER - 1);
    }

    @Test
    public void 숫자같은_경우_같다() {
        //given
        int number = 5;

        // then
        assertEquals(new LottoNumber(number), new LottoNumber(number));
    }
}
