package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-14.
 */
public class BestTimeToBuyAndSellStockTest {

    @Test
    public void maxProfit() {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        assertEquals(1, bestTimeToBuyAndSellStock.maxProfit(new int[]{1, 2}));
        assertEquals(0, bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
        assertEquals(0, bestTimeToBuyAndSellStock.maxProfit(new int[]{7}));
        assertEquals(5, bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, bestTimeToBuyAndSellStock.maxProfit(new int[]{3, 1}));
        assertEquals(2, bestTimeToBuyAndSellStock.maxProfit(new int[]{1, 3}));
    }
}