package lotto.domain;

import java.util.*;

public class Ranks {
    private Map<Integer, Rank> ranks;

    public Ranks() {
        ranks = new HashMap<>();

        Set<Integer> rankNumbers = WinningMoney.winningMoney.keySet();
        for (Integer rankNumber : rankNumbers) {
            ranks.put(rankNumber, new Rank(rankNumber));
        }

    }

    public double calculateProfit(long money) {
        double totalWinningMoney = 0.0;

        for (Integer rankNumber : ranks.keySet()) {
            totalWinningMoney += ranks.get(rankNumber).calculateWinningMoney();
        }

        return totalWinningMoney / money;
    }

    public void addMatchTicket(int matchCount) {

        if (matchCount < 3) return;

        if (ranks.containsKey(matchCount)) {
            ranks.get(matchCount).addTicketCount();
            return;
        }

        ranks.putIfAbsent(matchCount, new Rank(matchCount, 1));
    }

    public Map<Integer, Rank> getRanks() {
        return ranks;
    }
}
