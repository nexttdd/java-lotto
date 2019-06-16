package domain;

public class WinningLotto {

    private LottoSet winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(LottoSet winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchNumber(LottoSet lottoSet) {
        return lottoSet.countOfMatchNumber(winningLotto);
    }

    public boolean isMatchBonusNumber(LottoSet lottoSet) {
        return lottoSet.isMatchNumber(bonusNumber);
    }

}

