import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 21..
 */

public class Coin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int N = Integer.parseInt(params[0]);
        int K = Integer.parseInt(params[1]);
        int[] coins = new int[N];
        for (int n = 0 ; n < N ; n++) {
            coins[n] = Integer.parseInt(br.readLine());
        }
        Coin coin = new Coin();
        System.out.println(coin.solution(K, coins));
    }

    public int solution(int K, int[] coins) {
        int ans = 0;
        for (int i = coins.length - 1 ; i >= 0 && K != 0 ; i--) {
            if (K < coins[i]) { continue; }
            ans += K / coins[i];
            K %= coins[i];
        }
        return ans;
    }
}
