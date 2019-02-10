package state;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */
public class SelectableState implements State {
    @Override
    public void insertCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.insertCoin(coin);
    }

    @Override
    public void selectItem(int itemIdx, VendingMachine vendingMachine) {
        vendingMachine.produceItem(itemIdx);
        if (!vendingMachine.hasCoins()) {
            vendingMachine.changeState(new NoCoinState());
        }
    }
}
