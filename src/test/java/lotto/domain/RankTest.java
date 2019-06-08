package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    //TODO : rank생성결과 확인
    //TODO : count증가 확인


    @Test
    public void rank객체_생성() {
        //given
        int matchCount = 6;

        //when
        Rank rank = new Rank(matchCount);

        //then
        assertThat(rank.getMatchCount()).isEqualTo(6);
    }

    @Test
    public void 당첨개수_일치하는_티켓_count추가() {
        //given
        int matchCount = 6;
        Rank rank = new Rank(matchCount);

        //when
        rank.addTicketCount();

        //then
        assertThat(rank.getTicketCount()).isEqualTo(1);
    }

    @Test
    public void 당첨금_확인하기() {
        //given
        int matchCount = 3;
        Rank rank = new Rank(matchCount);
        rank.addTicketCount();

        //when
        int winningMoney = rank.calculateWinningMoney();

        //then
        assertThat(winningMoney).isEqualTo(5_000);
    }
}
