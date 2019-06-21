package lotto.domain;

import java.util.*;

public class Ranks {
    private Map<Reward, Rank> ranks;

    public Ranks() {
        ranks = new HashMap<>();
        for (Reward reward : Reward.values()) {
            ranks.put(reward, new Rank(reward));
        }
    }

    public double calculateProfit(long money) {
        double totalWinningMoney = 0.0;
        final double percent = 100.0;

        for (Reward reward : ranks.keySet()) {
            totalWinningMoney += ranks.get(reward).calculateWinningMoney();
        }

        return (totalWinningMoney / money) * percent;
    }

    public void addMatchTicket(int matchCount, boolean matchBonus) {
        if (matchCount < 3) return;

        Reward reward = Reward.valueOf(matchCount, matchBonus);

        if (ranks.containsKey(reward)) {
            ranks.get(reward).addTicketCount();
            return;
        }

        throw new IllegalArgumentException("wrong MatchCount");
    }

    public Map<Reward, Rank> getRanks() {
        return ranks;
    }
}
