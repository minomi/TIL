package medium.top_k_frequent_elements;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019/10/23.
 */
public class SolutionTest {

    @Test
    public void topKFrequent() {
        Solution solution = new Solution();
        List<Integer> actual = solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        List<Integer> expected = List.of(1, 2);
        assertEquals(actual, expected);


        actual = solution.topKFrequent(new int[]{1}, 1);
        expected = List.of(1);
        assertEquals(actual, expected);
    }
}