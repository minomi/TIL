package strategy.sort;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 04/11/2018.
 */
public class SortHandle <T extends Comparable<T>> {
    private T[] array;

    boolean outOfOrder(int i, int j) {
        return array[i].compareTo(array[j]) > 0;
    }

    void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void setArray(T[] array) {
        this.array = array;
    }

    T[] getArray() {
        return array;
    }
}


