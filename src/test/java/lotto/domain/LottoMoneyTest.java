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
    public void 수동_발급장수_확인() {
        //given
        long money = 1999;
        int manualTicketCount = 1;

        //when
        LottoMoney lottoMoney = new LottoMoney(money);
        lottoMoney.buyManualTicket(manualTicketCount);

        //then
        assertThat(lottoMoney.getManualTicketCount()).isEqualTo(1);
    }

    //then
    @Test(expected = IllegalArgumentException.class)
    public void 수동티켓_구매가능개수_초과() {
        //given
        LottoMoney lottoMoney = new LottoMoney(1000);
        int manualTicketCount = 2;

        //when
        lottoMoney.buyManualTicket(2);
    }

    @Test
    public void 자동구매_가능장수_확인() {
        //given
        LottoMoney lottoMoney = new LottoMoney(2000);

        //when
        lottoMoney.buyManualTicket(1);

        //then
        assertThat(lottoMoney.getAutoTicketCount()).isEqualTo(1);
    }

    @Test
    public void 수동발급_필요상태확인() {
        LottoMoney lottoMoney = new LottoMoney(1000);
        lottoMoney.buyManualTicket(1);

        assertThat(lottoMoney.isNeedManualTicket()).isTrue();
    }
}