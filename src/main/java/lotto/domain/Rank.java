package lotto.domain;

public class Rank {
    private static final int MIN_MATCH_COUNT = 3;

    private Reward reward;
    private int ticketCount;

    public Rank(Reward reward) {
        this.reward = reward;
    }

    public void addTicketCount() {
        ticketCount++;
    }

    public int calculateWinningMoney() {
        if(isUnLucky()) return 0;

        return reward.getWinningMoney() * ticketCount;
    }

    private boolean isUnLucky() {
        return reward.getMatchCount() < MIN_MATCH_COUNT;
    }

    public int getMatchCount() {
        return reward.getMatchCount();
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
