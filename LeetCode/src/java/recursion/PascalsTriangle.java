package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-31.
 */
public class PascalsTriangle {
    private List<List<Integer>> triangle = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        for (int y = 0 ; y < numRows ; y++) {
            List<Integer> row = Arrays.asList(new Integer[y + 1]);
            triangle.add(row);

            row.set(0, 1);
            row.set(y, 1);

            for (int x = 1 ; x < y ; x++) {
                row.set(x, valueAt(y, x));
            }
        }

        return triangle;
    }

    private int valueAt(int y, int x) {
        if (triangle.get(y).get(x) != null) {
            return triangle.get(y).get(x);
        }
        return valueAt(y - 1, x) + valueAt(y - 1, x - 1);
    }
}
