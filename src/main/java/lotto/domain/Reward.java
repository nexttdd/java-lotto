package lotto.domain;

public enum Reward {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    Reward(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    private int matchCount;
    private int winningMoney;

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Reward valueOf(int matchCount, boolean matchBonus) {
        Reward[] rewards = Reward.values();
        Reward yourReward = Reward.MISS;

        if (matchCount == Reward.SECOND.matchCount && matchBonus) {
            return Reward.SECOND;
        }

        for (Reward reward : rewards) {
            yourReward = findOne(matchCount, reward, yourReward);
        }
        return yourReward;
    }

    private static Reward findOne(int matchCount, Reward reward, Reward yourReward) {
        if (reward.matchCount == matchCount) {
            return reward;
        }
        return yourReward;
    }
}
