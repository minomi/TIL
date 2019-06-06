package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-26.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> appears = new HashSet<>();
        for (int num : nums) {
            if (appears.contains(num)) {
                return true;
            }
            appears.add(num);
        }
        return false;
    }
}
