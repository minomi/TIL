package state;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */
class VendingMachine {

    private int currentCoin;
    private State state;

    public VendingMachine(State state) {
        this.state = state;
    }

    void insertCoin(int coin) {
        state.insertCoin(coin, this);
    }

    void increaseCoin(int coin) {
        currentCoin += coin;
        System.out.println("현재 코인 : " + currentCoin);
    }

    void selectItem(int itemIdx) {
        state.selectItem(itemIdx, this);
    }

    void produceItem(int itemIdx) {
        System.out.println("idx : " + itemIdx + " 음료 제공");
    }

    void changeState(State state) {
        this.state = state;
    }

    boolean hasCoins() {
        return currentCoin > 0;
    }

}
