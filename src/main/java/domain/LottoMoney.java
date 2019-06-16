package domain;

public class LottoMoney {

    private int money;

    public LottoMoney(int money) {
        if (money < LottoGame.TICKET_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int getTryNo(int ticketPrice) {
        return money / ticketPrice;
    }
}
