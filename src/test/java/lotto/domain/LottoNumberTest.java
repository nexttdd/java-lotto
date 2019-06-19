package lotto.domain;

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

    @Test
    public void 일치개수_확인() {
        //given
        int matchCount = 3;
        String[] luckyNumbers = {"1", "2", "7", "4", "5", "6" };
        String bonusNumber = "3";
        LottoTicket luckyTicket = new LottoTicket(luckyNumbers, bonusNumber);
        LottoNumber lottoNumber = new LottoNumber(1);

        //when
        int currentMatchCount = lottoNumber.countMatchNumber(luckyTicket, matchCount);

        //then
        assertThat(currentMatchCount).isEqualTo(matchCount + 1);
    }

    @Test
    public void 보너스번호_일치확인() {
        //given
        LottoNumber bonusNumber = new LottoNumber(3);
        LottoNumber lottoNumber = new LottoNumber(3);

        //when, then
        assertThat(lottoNumber.isBonusNumber(bonusNumber, false)).isTrue();
    }
}