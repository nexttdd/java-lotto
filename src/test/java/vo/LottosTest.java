package vo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class LottosTest {
    @Test
    public void 자동로또만_생성() {
        //Give
        Lottos lottos = LottoGenerator.generateByMoney(new Money(5_000), null);

        //When
        //Then
        System.out.println(lottos);
        assertThat(lottos.count()).isEqualTo(5);
    }

    @Test
    public void 금액에서_수동구매제외한_자동구매리스트_생성() {
        //Given
        List<Lotto> manualLottos = Arrays.asList(Lotto.of("1,2,3,4,5,6"));

        //When
        Lottos lottos = LottoGenerator.generateByMoney(new Money(5_000), manualLottos);

        //Then
        System.out.println(lottos);
        assertThat(lottos.count()).isEqualTo(5);
    }
}