package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-26.
 */
public class ThreeSumTest {

    @Test
    public void threeSum() {
        ThreeSum _3sum = new ThreeSum();
        List<List<Integer>> actuals = _3sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<Integer> actualsRow = actuals.get(0);

        assertEquals(-1, actualsRow.get(0).intValue());
        assertEquals(-1, actualsRow.get(1).intValue());
        assertEquals(2, actualsRow.get(2).intValue());

        List<List<Integer>> actuals2 = _3sum.threeSum(new int[]{1,-1,-1,0});
        List<Integer> expectedRow2 = actuals2.get(0);
        assertEquals(-1, expectedRow2.get(0).intValue());
        assertEquals(0, expectedRow2.get(1).intValue());
        assertEquals(1, expectedRow2.get(2).intValue());
    }
}