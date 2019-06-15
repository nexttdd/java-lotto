package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningMoney {
    public static Map<Integer, Integer> winningMoney;
    static {
        winningMoney = new HashMap<>();
        winningMoney.put(6, 2_000_000_000);
        winningMoney.put(5, 1_500_000);
        winningMoney.put(4, 50_000);
        winningMoney.put(3, 5_000);
    }
}
