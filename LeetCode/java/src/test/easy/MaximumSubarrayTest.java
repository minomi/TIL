package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-24.
 */
public class MaximumSubarrayTest {

    @Test
    public void maxSubArray() {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        assertEquals(3, maximumSubarray.maxSubArray(new int[] {1, 1, 1}));
        assertEquals(1, maximumSubarray.maxSubArray(new int[] {-2, 1, -3 }));
        assertEquals(-1, maximumSubarray.maxSubArray(new int[] {-2, -1, -3 }));
        assertEquals(6, maximumSubarray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}