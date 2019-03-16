package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-16.
 */
public class RomanToIntegerTest {

    @Test
    public void romanToIntTest() {
        RomanToInteger romanToInteger = new RomanToInteger();
        assertEquals(3, romanToInteger.romanToInt("III"));
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(58, romanToInteger.romanToInt("LVIII"));
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));
    }
}