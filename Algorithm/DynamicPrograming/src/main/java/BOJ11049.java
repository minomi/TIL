import java.util.Arrays;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 11..
 */
public class BOJ11049 {

    public static void main(String[] args) {

    }

    public int solution(int[][] pairs) {
        int n = pairs.length;
        int[][] dp = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0 ; i < n ; i++) {
            dp[i][i] = 0;
        }

        for (int i = 0 ; i < n - 1 ; i++) {
            dp[i][i + 1] = pairs[i][0] * pairs[i][1] * pairs[i + 1][0];
        }

        for (int k = 0 ; k < n - 1 ; k++) {
            for (int i = 0; i < n ; i++) {
                for (int j = i + 2; j < n; j++) {
                    System.out.printf("%d, %d, %d\n", i, k, j);
                    System.out.printf("%d, %d\n", dp[i][k], dp[k + 1][j]);
                    System.out.printf("%d, %d, %d\n", pairs[i][0], pairs[k][1], pairs[j][1]);
                    int temp = dp[i][k] + dp[k + 1][j] + (pairs[i][0] * pairs[k][1] * pairs[j][1]);
                    System.out.println(temp);
                }
            }
        }

        return dp[0][n - 1];
    }

}
