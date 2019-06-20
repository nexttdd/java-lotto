package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static LottoMoney inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money = Long.parseLong(scanner.nextLine());

        return new LottoMoney(money);
    }

    public static String[] buyManualTickets(LottoMoney lottoMoney) {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualTicketCount = Integer.parseInt(scanner.nextLine());
        lottoMoney.buyManualTicket(manualTicketCount);

        return inputManualNumbers(lottoMoney);
    }

    private static String[] inputManualNumbers(LottoMoney lottoMoney) {
        if (lottoMoney.getManualTicketCount() == 0) {
            return new String[0];
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        String[] manualNumbers = new String[lottoMoney.getManualTicketCount()];

        for (int i = 0; i < lottoMoney.getManualTicketCount(); i++) {
            manualNumbers[i] = scanner.nextLine();
        }
        return manualNumbers;
    }

    public static LottoTicket inputLuckyLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] luckyNumbers = scanner.nextLine().split(",| ");

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = scanner.nextLine();
        return new LottoTicket(luckyNumbers, bonusBall);
    }
}
