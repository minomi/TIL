import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 2..
 */
public class BOJ2225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        System.out.println(solution(Integer.parseInt(splits[0]), Integer.parseInt(splits[1])));
    }

    public static int solution(int N, int K) {
        int mod = 1_000_000_000;
        int dp[][] = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);
        for (int i = 1 ; i <= K ; i++)
            dp[i][1] = i;

        for (int i = 2 ; i <= K ; i++)
            for (int j = 2 ; j <= N ; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }

        return dp[K][N];
    }
}
