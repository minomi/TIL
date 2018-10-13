import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 11..
 */
public class BOJ11049Test {

    private BOJ11049 boj11049;

    @Before
    public void setUp() {
        boj11049 = new BOJ11049();
    }

    @Test
    public void solution() {
        int answer = boj11049.solution(new int[][] {
                        new int[] {5, 3},
                        new int[] {3, 2},
                        new int[] {2, 6}
        });
        assertEquals(90, answer);
    }
}