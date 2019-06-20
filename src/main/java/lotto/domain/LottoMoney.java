package lotto.domain;

public class LottoMoney {
    private static final long TICKET_PRICE = 1_000L;

    private long money;
    private int manualTicketCount;

    public LottoMoney(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public void buyManualTicket(int manualTicketCount) {
        checkOutOfRange(manualTicketCount);
        this.manualTicketCount = manualTicketCount;
    }

    private void checkOutOfRange(int ticketCount) {
        if (money / TICKET_PRICE < ticketCount) throw new IllegalArgumentException("구매가능 장수 초과");
    }

    public long getMoney() {
        return money;
    }

    public int getAutoTicketCount() {
        return (int) (money / TICKET_PRICE) - manualTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }
}