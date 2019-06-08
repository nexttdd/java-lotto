package lotto.domain;

public class LottoMoney {
    private static final long TICKET_PRICE = 1_000L;

    private long money;
    private int ticketCount;

    public LottoMoney(long money) {
        validate(money);
        this.money = money;
        ticketCount = (int) (money / TICKET_PRICE);
    }

    private boolean validate(long money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public long getMoney() {
        return money;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}