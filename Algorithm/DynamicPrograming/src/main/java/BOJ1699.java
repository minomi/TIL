
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 26..
 */
public class BOJ1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solution(N));
    }

    public static int[] getBeforePerfectSquares(int N) {
        int[] perfectSquares = new int[N + 1];
        for (int i = 1 ; i < 400 ; i++) {
            int prev = i * i, next = (i + 1) * (i + 1);
            for (int j = prev ; j < next ; j++) {
                if (j > N) return perfectSquares;
                perfectSquares[j] = prev;
            }
        }
        return perfectSquares;
    }

    public static int solution(int num) {
        int[] beforePerfectSquares = getBeforePerfectSquares(num);
        int[] dp = new int[num + 1];
        Arrays.fill(dp, 999999);
        dp[0] = 0;

        for(int i = 2; i <= num; i++) {
            int beforePerfectSquare = beforePerfectSquares[i];
            int sqrt = (int) Math.sqrt(beforePerfectSquare);
            for (int j = sqrt ; j >= sqrt / 2; j--) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[num];
    }
}
