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

    public String calculateProfit(long money) {
        double totalWinningMoney = 0.0;

        for (Reward reward : ranks.keySet()) {
            totalWinningMoney += ranks.get(reward).calculateWinningMoney();
        }

        double profit = totalWinningMoney / money;

        return String.format(profit < 1 ? "%.2f" : "%.0f", profit);
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
        return Collections.unmodifiableMap(ranks);
    }

    public Rank getRank(Reward reward) {
        return ranks.get(reward);
    }
}
