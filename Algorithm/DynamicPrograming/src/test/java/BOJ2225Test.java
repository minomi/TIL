import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 2..
 */
public class BOJ2225Test {

    @Test
    public void solution() {
        assertEquals(21, BOJ2225.solution(20, 2));
        assertEquals(20, BOJ2225.solution(3, 4));
        assertEquals(15, BOJ2225.solution(4, 3));
    }
}