import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 21..
 */
public class CoinTest {

    Coin coin = new Coin();

    @Test
    public void solution() {
        int ans = coin.solution(4200, new int[]{1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000});
        assertEquals(6, ans);

        ans = coin.solution(4790, new int[]{1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000});
        assertEquals(12, ans);

        ans = coin.solution(4790, new int[]{1});
        assertEquals(4790, ans);
    }
}