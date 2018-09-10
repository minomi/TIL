import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 10..
 */

public class BOJ10942 {
    public int[][] dp;
    private int[] progression;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] progression = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BOJ10942 boj10942 = new BOJ10942(progression);
        int m = Integer.parseInt(br.readLine());
        boj10942.palindromeBottomUp();
        for (int i = 0 ; i < m ; i++) {
            String[] split= br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            System.out.println(boj10942.dp[s - 1][e - 1]);
        }
    }

    public BOJ10942(int[] progression) {
        this.progression = progression;
        int n = progression.length;
        dp = new int[n][n];
        for (int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }
    }

    public void palindromeBottomUp() {
        int n = this.progression.length;
        for (int i = 0 ; i < n ; i++)
            dp[i][i] = 1;
        for (int i = 0 ; i < n - 1 ; i++)
            if (progression[i] == progression[i + 1])
                dp[i][i + 1] = 1;
        for (int k = 2 ; k < n ; k++)
            for (int i = 0 ; i < n - k + 1 ; k++) {
                int j = i + k - 1;
                if (progression[i] == progression[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
    }

    public int isPalindrome(int s, int e) {
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        if (s == e) {
            return 1;
        }
        if (s + 1 == e) {
            return (progression[s] == progression[e]) ? 1 : 0;
        }
        if (progression[s] == progression[e]) {
            return (dp[s][e] = isPalindrome(s + 1, e - 1));
        }
        return 0;
    }
}
