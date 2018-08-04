import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 4..
 */
public class BOJ1963Test {

    @Before
    public void setUp() {
        BOJ1963.runEratosSieve();
        BOJ1963.clearBeforeSolution();
    }

    @Test
    public void solution() {
        assertEquals(6, BOJ1963.solution(1033, 8179));
        assertEquals(7, BOJ1963.solution(1373, 8017));
        assertEquals(0, BOJ1963.solution(1033, 1033));
    }

    @Test
    public void eratosSieve() {
        assertTrue(BOJ1963.prime[2]);
        assertTrue(BOJ1963.prime[3]);
        assertFalse(BOJ1963.prime[4]);
        assertTrue(BOJ1963.prime[1033]);
        assertTrue(BOJ1963.prime[8179]);
    }

    @Test
    public void change() {
        assertEquals(1733, BOJ1963.change(1033, 1, 7));
        assertEquals(3733, BOJ1963.change(1733, 0, 3));
        assertEquals(0, BOJ1963.change(1033, 0, 8));
    }
}