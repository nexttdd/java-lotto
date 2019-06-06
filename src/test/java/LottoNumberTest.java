import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void 정상생성() {
        //given,when
        LottoNumber lottoNumber = new LottoNumber(3);

        //then
        assertThat(lottoNumber.getNumber()).isEqualTo(3);
    }

    //then
    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_범위를_벗어난_숫자() {
        //given,when
        LottoNumber lottoNumber = new LottoNumber(46);
    }

    //then
    @Test(expected = IllegalArgumentException.class)
    public void 중복된_숫자() {
        //given
        LottoNumber lottoNumber = new LottoNumber(3);
        LottoNumber dupLottoNumber = new LottoNumber(3);

        //when
        lottoNumber.compareTo(dupLottoNumber);
    }
}