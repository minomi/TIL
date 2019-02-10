package state;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */
class Client {
    void insertCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.insertCoin(coin);
    }

    void select(int itemIdx, VendingMachine vendingMachine) {
        vendingMachine.selectItem(itemIdx);
    }
}
