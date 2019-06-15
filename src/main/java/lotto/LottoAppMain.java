package lotto;

import lotto.service.LottoGameService;

public class LottoAppMain {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        new LottoGameService().run();
    }
}