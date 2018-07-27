
import java.util.Arrays;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 27..
 */

public class Permutation {
    private int[] numbers;

    public Permutation(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    public boolean next() {
        int i = numbers.length - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) {i--;}
        if (i <= 0) {return false;}
        int j = numbers.length - 1;
        while (numbers[j] <= numbers[i - 1]) {j--;}
        Permutation.swap(numbers, j, i - 1);
        Permutation.reverseFrom(i, numbers);
        return true;
    }

    public boolean prev() {
        int i = numbers.length - 1;
        while (i > 0 && numbers[i - 1] <= numbers[i]) {i--;}
        if(i <= 0) {return false;}
        int j = numbers.length - 1;
        while (numbers[j] >= numbers[i - 1]) {j--;}
        Permutation.swap(numbers, j, i - 1);
        Permutation.reverseFrom(i, numbers);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Permutation)) {
            return false;
        }

        Permutation rhs = (Permutation) obj;

        if (rhs.getNumbers().length != this.numbers.length) {
            return false;
        }

        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] != rhs.getNumbers()[i]) {
                return false;
            }
        }

        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    public static void reverseFrom(int from, int[] arr) {
        int end = arr.length - 1;
        while (from < end) {
            Permutation.swap(arr, from ,end);
            from++;
            end--;
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, numbers.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int n : numbers) {
            sb.append(n);
            sb.append(" ");
        }
        return sb.toString();
    }
}
