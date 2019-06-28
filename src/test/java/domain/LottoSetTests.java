package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;


public class LottoSetTests {

    private LottoSet lottoSet;

    @Before
    public void setUp() {
        lottoSet = new LottoSet(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    @Test
    public void 로또_세트는_오름차순으로_정렬된다() {
        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(20),
                new LottoNumber(10),
                new LottoNumber(5),
                new LottoNumber(44),
                new LottoNumber(23),
                new LottoNumber(11));

        // when
        LottoSet lottoSet = new LottoSet(lottoNumbers);

        //then
        List<LottoNumber> result = lottoSet.getLottoNumbers();
        for (int i = 1; i < result.size(); i++) {
            assertThat(result.get(i - 1).compareTo(result.get(i))).isLessThanOrEqualTo(1);
        }
    }

    @Test
    public void 당첨번호_매칭수_일치() {
        assertThat(lottoSet.countOfMatchNumber(new LottoSet(7, 8, 9, 10, 11, 12))).isEqualTo(0);
        assertThat(lottoSet.countOfMatchNumber(new LottoSet(2, 3, 4, 5, 6, 7))).isEqualTo(5);
        assertThat(lottoSet.countOfMatchNumber(new LottoSet(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @Test
    public void 번호_매칭_일치() {
        assertFalse(lottoSet.isMatchNumber(new LottoNumber(7)));
        assertThat(lottoSet.isMatchNumber(new LottoNumber(6)));
    }

    @Test
    public void 로또_사이즈() {
        assertThat(new LottoSet(1, 2, 3, 4, 5, 6).getLottoNumbers()).hasSize(LottoGenerator.LOTTO_SIZE);
    }
}