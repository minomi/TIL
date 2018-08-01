import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */
public class PermutationTest {

    @Test
    public void next() {
        List<Integer> permutation = Arrays.asList(1,2,3,4);
        Permutation.next(permutation);
        assertArrayEquals(Arrays.asList(1,2,4,3).toArray(), permutation.toArray());
    }
}