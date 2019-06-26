package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {
    @Test
    public void Ranks객체생성() {
        //given, when
        Ranks ranks = new Ranks();

        //then
        assertThat(ranks).isNotNull();
    }

    @Test
    public void 이득_수익률_계산하기() {
        //given
        int money = 5_000;

        //when
        Ranks ranks = new Ranks();
        ranks.addMatchTicket(3, Boolean.FALSE);
        String profit = ranks.calculateProfit(money);

        //then
        assertThat(profit).isEqualTo("1");
    }

    @Test
    public void 손해_수익률_계산하기() {
        //given
        int money = 15_000;

        //when
        Ranks ranks = new Ranks();
        ranks.addMatchTicket(3, Boolean.FALSE);
        String profit = ranks.calculateProfit(money);

        //then
        assertThat(profit).isEqualTo("0.33");
    }


    @Test
    public void FIFTH_티켓_추가() {
        //given
        Reward reward = Reward.FIFTH;
        Ranks ranks = new Ranks();

        //when
        ranks.addMatchTicket(3, Boolean.FALSE);

        //then
        assertThat(ranks.getRanks().get(reward)).isNotNull();
    }
}
