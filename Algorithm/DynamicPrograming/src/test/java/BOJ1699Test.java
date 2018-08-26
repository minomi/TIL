import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 26..
 */
public class BOJ1699Test {

    @Test
    public void solution() {
        assertEquals(4, BOJ1699.solution(7));
        assertEquals(3, BOJ1699.solution(11));
        assertEquals(3, BOJ1699.solution(12));
        assertEquals(1, BOJ1699.solution(16));
        assertEquals(1, BOJ1699.solution(100));
    }

    @Test
    public void getBeforePerfectSquares() {
        assertArrayEquals(new int[]{0, 1, 1, 1, 4}, BOJ1699.getBeforePerfectSquares(4));
        assertArrayEquals(new int[]{0, 1, 1, 1, 4, 4, 4, 4}, BOJ1699.getBeforePerfectSquares(7));
        assertArrayEquals(new int[]{0, 1, 1, 1, 4, 4, 4, 4, 4, 9}, BOJ1699.getBeforePerfectSquares(9));
    }
}