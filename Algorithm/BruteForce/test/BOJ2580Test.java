import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 7..
 */
public class BOJ2580Test {

    @Test
    public void square() {
        assertEquals(0, BOJ2580.squareIdx(0, 0));
        assertEquals(0, BOJ2580.squareIdx(1, 0));
        assertEquals(0, BOJ2580.squareIdx(1, 1));
        assertEquals(3, BOJ2580.squareIdx(4, 2));
        assertEquals(4, BOJ2580.squareIdx(5, 3));
    }
}