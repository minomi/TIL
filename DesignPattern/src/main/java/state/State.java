package state;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */
public interface State {
    void insertCoin(int coin, VendingMachine vendingMachine);
    void selectItem(int itemIdx, VendingMachine vendingMachine);
}
