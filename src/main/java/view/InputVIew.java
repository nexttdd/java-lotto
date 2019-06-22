package view;

import vo.Lotto;
import vo.LottoNumber;
import vo.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputVIew {
    public String purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public int manualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

    public List<Lotto> manualLottoNumbers(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner  =  new Scanner(System.in);
        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0 ; i < manualCount ; i++) {
            manualLottos.add(Lotto.of(scanner.nextLine()));
        }
        return manualLottos;
    }

    public WinningLotto winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumber = scanner.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return new WinningLotto(Lotto.of(winningNumber), LottoNumber.of(bonusNumber));
    }
}
