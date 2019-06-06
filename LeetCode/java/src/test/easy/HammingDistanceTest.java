package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-30.
 */
public class HammingDistanceTest {

    @Test
    public void hammingDistance() {
        HammingDistance hammingDistance = new HammingDistance();
        assertEquals(2, hammingDistance.hammingDistance(1, 4));
        assertEquals(0, hammingDistance.hammingDistance(0, 0));
        assertEquals(4, hammingDistance.hammingDistance(5, 10));
        assertEquals(4, hammingDistance.hammingDistance(10, 5));
        assertEquals(0, hammingDistance.hammingDistance(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(31, hammingDistance.hammingDistance(0, Integer.MAX_VALUE));
    }
}