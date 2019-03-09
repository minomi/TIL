package easy;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-09.
 */
public class TwoSumTest {
    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, new TwoSum().twoSum(new int[]{1, 2}, 3));
        assertArrayEquals(new int[]{0, 1}, new TwoSum().twoSum(new int[]{-1, 2}, 1));
        assertArrayEquals(new int[]{0, 2}, new TwoSum().twoSum(new int[]{1, 4, 2}, 3));
        assertArrayEquals(new int[]{0, 1}, new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{0, 2}, new TwoSum().twoSum(new int[]{-2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{0, 4}, new TwoSum().twoSum(new int[]{0, 3, -3, 4, -1}, -1));
    }
}