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
    public void 수익률_계산하기() {
        //given
        int money = 5_000;

        //when
        Ranks ranks = new Ranks();
        ranks.addMatchTicket(3, Boolean.FALSE);
        double profit = ranks.calculateProfit(money);

        //then
        assertThat(profit).isEqualTo(1.0);
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
