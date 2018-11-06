package strategy.sort;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 04/11/2018.
 */
public class BubbleSort <T extends Comparable<T>> {

    private SortHandle<T> sortHandle;

    BubbleSort(SortHandle<T> sortHandle) {
        this.sortHandle = sortHandle;
    }

    public void sort(T[] array) {
        sortHandle.setArray(array);
        for (int i = array.length - 1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (sortHandle.outOfOrder(j, j + 1)) {
                    sortHandle.swap(j, j + 1);
                }
            }
        }
    }

    public SortHandle<T> getSortHandle() {
        return sortHandle;
    }
}
