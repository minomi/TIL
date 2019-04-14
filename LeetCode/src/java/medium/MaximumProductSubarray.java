package medium;

import java.util.Collections;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-14.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            int cur = nums[i];
            dp[0][i] = Math.max(dp[0][i - 1] * cur, Math.max(dp[1][i - 1] * cur, cur));
            dp[1][i] = Math.min(dp[1][i - 1] * cur, Math.min(dp[0][i - 1] * cur, cur));
        }
        return max(dp[0]);
    }

    private int max(int[] arr) {
        int ret = arr[0];
        for (int n : arr) {
            ret = Math.max(ret, n);
        }
        return ret;
    }
}
