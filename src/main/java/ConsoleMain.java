import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoMoney(InputView.inputBuyPrice()));
        List<LottoSet> lottoPaper = lottoGame.start();
        ResultView.printBuyLottoPaper(lottoPaper);
        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningLotto(), InputView.inputBonusNumber());
        LottoResult lottoResult = new LottoResult(lottoPaper, winningLotto);
        ResultView.printLottoResult(lottoResult);
    }
}
