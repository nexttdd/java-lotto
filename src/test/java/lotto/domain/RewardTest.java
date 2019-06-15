package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @Test
    public void FIRST_당첨확인() {
        //given
        int matchCount = 6;

        //when
        Reward first = Reward.valueOf(matchCount, Boolean.FALSE);

        //then
        assertThat(first.getWinningMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    public void 보너스당첨_확인() {
        //given
        int matchCount = 5;
        boolean matchBonus = Boolean.TRUE;

        //when
        Reward second = Reward.valueOf(matchCount, matchBonus);

        //then
        assertThat(second.getWinningMoney()).isEqualTo(30_000_000);
    }

    @Test
    public void 보너스는_당첨됐지만_2등은_아닌경우() {
        //given
        int matchCount = 3;
        boolean matchBonus = Boolean.TRUE;

        //when
        Reward reward = Reward.valueOf(matchCount, matchBonus);

        //then
        assertThat(reward.getWinningMoney()).isEqualTo(5_000);
    }

    @Test
    public void 당첨안된경우() {
        //given
        int matchCount = 2;
        boolean matchBonus = Boolean.TRUE;

        //when
        Reward reward = Reward.valueOf(matchCount, matchBonus);

        //then
        assertThat(reward.getWinningMoney()).isEqualTo(0);
    }
}
