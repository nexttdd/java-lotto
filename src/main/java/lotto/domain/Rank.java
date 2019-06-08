package lotto.domain;

public class Rank {
    private static final int MIN_MATCH_COUNT = 3;

    private int matchCount;
    private int ticketCount;

    public Rank(int matchCount) {
        this.matchCount = matchCount;
    }

    public Rank(int matchCount, int ticketCount) {
        this.matchCount = matchCount;
        this.ticketCount = ticketCount;
    }

    public void addTicketCount() {
        ticketCount++;
    }

    public int calculateWinningMoney() {
        if(isUnLucky()) return 0;

        return WinningMoney.winningMoney.get(matchCount) * ticketCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private boolean isUnLucky() {
        return matchCount < MIN_MATCH_COUNT;
    }

    public void addTicketCount(int matchCount) {
        if (this.matchCount == matchCount) {
            addTicketCount();
        }
    }
}
