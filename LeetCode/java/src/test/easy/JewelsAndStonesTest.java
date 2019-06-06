package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-26.
 */
public class JewelsAndStonesTest {
    @Test
    public void numJewelsInStones() {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        assertEquals(3, jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
        assertEquals(0, jewelsAndStones.numJewelsInStones("z", "ZZ"));
        assertEquals(0, jewelsAndStones.numJewelsInStones("", ""));
        assertEquals(0, jewelsAndStones.numJewelsInStones("", "zzzl"));
    }
}