package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {
    //TODO : rankList 일급 콜랙션
    //TODO : 수익률 계산 및 저장.
    private List<Rank> rank;

    @Before
    public void setUp() throws Exception {
        rank = Arrays.asList(
                new Rank(6,0),
                new Rank(5,0),
                new Rank(4,0),
                new Rank(3,1)
        );
    }

    @Test
    public void ranks객체_생성() {
        Ranks ranks = new Ranks();
        assertThat(ranks).isNotNull();
    }

    @Test
    public void 수익률_계산하기() {
        int money = 5_000;

        Ranks ranks = new Ranks();
        ranks.addMatchTicket(3);
        double profit = ranks.calculateProfit(money);

        assertThat(profit).isEqualTo(1.0);
    }
}
