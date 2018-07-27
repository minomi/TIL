import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 27..
 */
public class PermutationTest {

    @Test
    public void nextTest_순열_길이가_0_or_1_일때는_false() {
        int[] numbers = new int[] {};
        Permutation permutation = new Permutation(numbers);
        assertFalse(permutation.next());
        permutation.setNumbers(new int[]{1});
        assertFalse(permutation.next());
    }

    @Test
    public void nextTest_순열_길이가_2일때() {
        int[] numbers = new int[] {1, 2};
        Permutation permutation = new Permutation(numbers);
        assertTrue(permutation.next());
        assertEquals(new Permutation(new int[]{2, 1}), permutation);
        assertFalse(permutation.next());
    }

    @Test
    public void prevTest_순열_길이가_0_or_1_일때_false() {
        int[] numbers = new int[] {};
        Permutation permutation = new Permutation(numbers);
        assertFalse(permutation.prev());
        permutation.setNumbers(new int[]{1});
        assertFalse(permutation.prev());
    }

    @Test
    public void prevTest_순열_길이가_2일때() {
        int[] numbers = new int[] {2, 1};
        Permutation permutation = new Permutation(numbers);
        assertTrue(permutation.prev());
        assertEquals(new Permutation(new int[]{1, 2}), permutation);
        assertFalse(permutation.prev());
    }


    @Test
    public void swap_idx1_idx2() {
        int[] arr = new int[]{1, 2, 3, 4};
        Permutation.swap(arr, 0, 1);
        assertEquals(2 ,arr[0]);
        assertEquals(1, arr[1]);
    }

    @Test
    public void reverseFromIdx() {
        int[] arr = new int[]{1, 2, 3, 4};
        Permutation.reverseFrom(1, arr);
        assertEquals( 4, arr[1]);
        assertEquals( 3, arr[2]);
        assertEquals( 2, arr[3]);
    }
}