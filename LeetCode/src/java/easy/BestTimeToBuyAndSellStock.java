package easy;

import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-14.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int currentMax = Integer.MIN_VALUE;
        int maxProfit = 0;
        for (int i = prices.length - 1 ; i > 0 ; i--) {
            currentMax = Math.max(currentMax, prices[i]);
            maxProfit = Math.max(currentMax - prices[i - 1], maxProfit);
        }
        return maxProfit;
    }
}
