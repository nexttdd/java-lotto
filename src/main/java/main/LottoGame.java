package main;

import view.InputVIew;
import view.ResultView;
import vo.*;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        InputVIew inputView = new InputVIew();
        ResultView resultView = new ResultView();

        Money money = new Money(inputView.purchaseAmount());

        int manualCount = inputView.manualCount(money);

        List<Lotto> manualLottos = inputView.manualLottoNumbers(manualCount);
        resultView.printPurchaseTicketCount(manualCount, money.getExceptManualCount(manualCount));

        Lottos lottos = LottoGenerator.generateByMoney(money, manualLottos);
        System.out.println(lottos);

        WinningLotto winningNumber = inputView.winningNumber();
        MatchingResults result = lottos.match(winningNumber);

        resultView.show(result);
    }
}
