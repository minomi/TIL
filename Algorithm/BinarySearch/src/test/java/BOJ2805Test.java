import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 3..
 */
class BOJ2805Test {

    @Test
    void solution() {
        assertEquals(15, BOJ2805.solution(7, new long[]{20, 15, 10, 17}));
        assertEquals(0, BOJ2805.solution(62, new long[]{20, 15, 10, 17}));
        assertEquals(1, BOJ2805.solution(19, new long[]{20}));
    }
}