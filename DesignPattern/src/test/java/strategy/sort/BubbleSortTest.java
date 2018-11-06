package strategy.sort;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 04/11/2018.
 */
public class BubbleSortTest {

    @Test
    public void sort() {
        String[] array = new String[] {"ddd", "eft", "xxx", "abc"};
        SortHandle<String> sortHandle = new SortHandle<>();
        BubbleSort<String> bubbleSort = new BubbleSort<>(sortHandle);
        bubbleSort.sort(array);
        assertArrayEquals(new String[] {"abc", "ddd", "eft", "xxx"},
                bubbleSort.getSortHandle().getArray());

        new SortHandle<String>() {
            @Override
            boolean outOfOrder(int i, int j) {
                return super.outOfOrder(i, j);
            }
        };
    }

}