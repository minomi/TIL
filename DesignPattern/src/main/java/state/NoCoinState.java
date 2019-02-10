package state;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */
public class NoCoinState implements State {
    @Override
    public void insertCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.increaseCoin(coin);
        vendingMachine.changeState(new SelectableState());
    }

    @Override
    public void selectItem(int itemIdx, VendingMachine vendingMachine) {
        // 아무 동작 하지 않음
    }
}
