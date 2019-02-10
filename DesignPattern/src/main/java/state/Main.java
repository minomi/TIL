package state;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(new NoCoinState());
        Client client = new Client();

        client.insertCoin(5, vendingMachine);
        client.select(1, vendingMachine);
    }
}
