package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static LottoMoney inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money = Long.parseLong(scanner.nextLine());

        LottoMoney lottoMoney = new LottoMoney(money);
        System.out.println(lottoMoney.getTicketCount() + "개를 구매했습니다.");
        return lottoMoney;
    }

    public static LottoTicket inputLuckyLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] luckyNumbers = scanner.nextLine().split(",| ");
        return new LottoTicket(luckyNumbers);
    }
}
