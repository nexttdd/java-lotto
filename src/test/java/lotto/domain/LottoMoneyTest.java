package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {
    //then
    @Test(expected = IllegalArgumentException.class)
    public void 최소금액_미만오류() {
        //given
        long money = 600;

        //when
        LottoMoney lottoMoney = new LottoMoney(money);
    }

    @Test
    public void 발급장수_확인() {
        //given
        long money = 1999;

        //when
        LottoMoney lottoMoney = new LottoMoney(money);

        //then
        assertThat(lottoMoney.getTicketCount()).isEqualTo(1);
    }
}