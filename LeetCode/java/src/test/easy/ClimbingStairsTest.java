package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-14.
 */
public class ClimbingStairsTest {

    @Test
    public void climbStairs() {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        assertEquals(2, climbingStairs.climbStairs(2));
        assertEquals(3, climbingStairs.climbStairs(3));
        assertEquals(5, climbingStairs.climbStairs(4));
    }
}