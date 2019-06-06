package easy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-14.
 */
public class ClimbingStairs {
    private int[] dp = new int[10000];
    public int climbStairs(int n) {
        return iterativelyClimbing(n);
    }

    private int iterativelyClimbing(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private int recursivelyClimbing(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return dp[n] = recursivelyClimbing(n - 1) + recursivelyClimbing(n - 2);
    }
}
