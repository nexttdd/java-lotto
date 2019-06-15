package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void Rank객체생성() {
        //given
        Reward first = Reward.FIRST;

        //when
        Rank rank = new Rank(first);

        //then
        assertThat(rank.getMatchCount()).isEqualTo(6);
    }

    @Test
    public void 당첨금_확인하기() {
        //given
        Reward reward = Reward.FIFTH;

        //when
        Rank rank = new Rank(reward);
        rank.addTicketCount();

        //then
        assertThat(rank.calculateWinningMoney()).isEqualTo(5_000);
    }

    @Test
    public void 당첨개수_일치하는_티켓_count추가() {
        //given
        Reward first = Reward.FIRST;
        Rank rank = new Rank(first);

        //when
        rank.addTicketCount();

        //then
        assertThat(rank.getTicketCount()).isEqualTo(1);
    }
}
