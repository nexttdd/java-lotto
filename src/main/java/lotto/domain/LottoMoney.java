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
        if (calcTicketCount() < ticketCount) {
            throw new IllegalArgumentException("구매할 수 있는 로또 티켓 수를 초과했습니다.");
        }
    }

    public long getMoney() {
        return money;
    }

    public int getAutoTicketCount() {
        return calcTicketCount() - manualTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public boolean isNeedManualTicket() {
        return this.manualTicketCount > 0;
    }

    private int calcTicketCount() {
        return (int) (money / TICKET_PRICE);
    }

    public void buyManualTicket(String[] manualNumber) {
        if (manualNumber[0].trim().equals("")) {
            return;
        }
        buyManualTicket(manualNumber.length);
    }
}