import org.junit.Test;

import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */
public class BOJ10971Test {

    @Test
    public void solution() {
        List<int[]> W = new ArrayList();
        W.add(Arrays.asList(0, 10, 15, 20).stream().mapToInt(Integer::intValue).toArray());
        W.add(Arrays.asList(5, 0, 9, 10).stream().mapToInt(Integer::intValue).toArray());
        W.add(Arrays.asList(6, 13, 0, 12).stream().mapToInt(Integer::intValue).toArray());
        W.add(Arrays.asList(8, 8, 9, 0).stream().mapToInt(Integer::intValue).toArray());
        assertEquals(35, BOJ10971.solution(W, 4));
    }
}