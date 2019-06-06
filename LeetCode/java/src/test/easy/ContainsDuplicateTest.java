package easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-26.
 */
public class ContainsDuplicateTest {

    @Test
    public void containsDuplicate() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        assertFalse(containsDuplicate.containsDuplicate(new int[] {1,2,3}));
        assertTrue(containsDuplicate.containsDuplicate(new int[] {1,1,3}));
    }
}