package recursion;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-31.
 */
public class PascalsTriangleTest {

    @Test
    public void generate() {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<Integer> row1 = List.of(1);
        List<Integer> row2 = List.of(1, 1);
        List<Integer> row3 = List.of(1, 2, 1);
        List<Integer> row4 = List.of(1, 3, 3, 1);
        List<Integer> row5 = List.of(1, 4, 6, 4, 1);
        List<List<Integer>> excepted = List.of(row1, row2, row3, row4, row5);
        List<List<Integer>> actuals = pascalsTriangle.generate(5);

        for (int i = 0 ; i < 5 ; i++) {
            assertArrayEquals(excepted.get(i).toArray(), actuals.get(i).toArray());
        }
    }
}