import java.util.Collections;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */
public class Permutation {
    public static boolean next(List<Integer> numbers) {
        int i = numbers.size() - 1;
        while (i > 0 && numbers.get(i - 1) >= numbers.get(i)) {i--;}
        if (i <= 0) {return false;}
        int j = numbers.size() - 1;
        while (numbers.get(j) <= numbers.get(i - 1)) {j--;}
        Collections.swap(numbers, i - 1, j);
        j = numbers.size() - 1;
        while (i < j) {
            Collections.swap(numbers, i, j);
            i++;
            j--;
        }
        return true;
    }
}
