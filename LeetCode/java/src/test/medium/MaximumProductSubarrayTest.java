package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-14.
 */
public class MaximumProductSubarrayTest {

    @Test
    public void maxProduct() {
        MaximumProductSubarray maximumSubarray = new MaximumProductSubarray();
        assertEquals(6, maximumSubarray.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, maximumSubarray.maxProduct(new int[]{-2, 0, -1}));
    }
}