package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private List<LottoNumber> lottoNumbers;

    @Before
    public void setUp() {
        //givein
        lottoNumbers = Arrays.asList(
                new LottoNumber(6), new LottoNumber(5), new LottoNumber(4)
                , new LottoNumber(3), new LottoNumber(2), new LottoNumber(1));
    }

    @Test
    public void 로또티켓만들기() {
        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        System.out.println(lottoTicket.toString());

        //then
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 보너스번호_일치확인() {
        //given
        String[] luckyNumbers = {"1", "2", "7", "4", "5", "6" };
        String bonusNumber = "3";
        LottoTicket luckyTicket = new LottoTicket(luckyNumbers, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //when
        lottoTicket.matchBonusNumber(luckyTicket);

        //then
        assertThat(lottoTicket.isBonusMatch()).isTrue();
    }
}
