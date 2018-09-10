import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 10..
 */
public class BOJ10942Test {

    private BOJ10942 test;

    @Before
    public void setUp() {
        test = new BOJ10942(new int[] {1, 2, 1, 3, 1, 2, 1});
    }

    @Test
    public void isPalindrome1() {
        int actual = test.isPalindrome(0, 2);
        assertEquals(1, actual);
    }

    @Test
    public void isPalindrome2() {
        int actual = test.isPalindrome(1, 4);
        assertEquals(1, actual);
    }

    @Test
    public void isPalindrome3() {
        int actual = test.isPalindrome(2, 2);
        assertEquals(0, actual);
    }

    @Test
    public void isPalindrome4() {
        int actual = test.isPalindrome(4, 6);
        assertEquals(1, actual);
    }
}