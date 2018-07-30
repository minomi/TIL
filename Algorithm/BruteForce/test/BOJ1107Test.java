import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 31..
 */
public class BOJ1107Test {

    BOJ1107 boj1107;

    @Before
    public void setUp() {
        boj1107 = new BOJ1107();
    }

    @Test
    public void solution() {
        assertEquals(6, boj1107.solution(5457,
                new boolean[] {false, false, false, false, false, false, true, true, true, false}));

        assertEquals(0, boj1107.solution(100,
                new boolean[] {false, false, false, false, false, false, true, true, true, false}));

        assertEquals(11117, boj1107.solution(500000,
                new boolean[] {true, false, true, true, true, false, true, true, true, true}));
    }

    @Test
    public void possible() {
        boolean[] brokens = new boolean[] {false, false, false, false, true, true, false, true, false, true};
        assertEquals(1, boj1107.possible(0, brokens));
        assertEquals(0, boj1107.possible(1234, brokens));
        assertEquals(3, boj1107.possible(123, brokens));
        assertEquals(6, boj1107.possible(120368, brokens));
    }
}