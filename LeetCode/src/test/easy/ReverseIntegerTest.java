package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-11.
 */
public class ReverseIntegerTest {

    @Test
    public void test_ReverseInteger() {
        ReverseInteger reverseInteger = new ReverseInteger();
        assertEquals(321, reverseInteger.reverse(123));
        assertEquals(-321, reverseInteger.reverse(-123));
        assertEquals(21, reverseInteger.reverse(120));
        assertEquals(0, reverseInteger.reverse(0));
        assertEquals(1, reverseInteger.reverse(1));
        assertEquals(-1, reverseInteger.reverse(-1));
        assertEquals(0, reverseInteger.reverse(1534236469));
        assertEquals(0, reverseInteger.reverse(-1534236469));
    }
}