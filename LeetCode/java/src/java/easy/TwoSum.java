package easy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-09.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum  {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexTable = new HashMap<>();
        for (int curIdx = 0 ; curIdx < nums.length ; curIdx++) {
            if (indexTable.containsKey(-nums[curIdx])) {
                int prevIdx = indexTable.get(-nums[curIdx]);
                return new int[] {prevIdx, curIdx};
            }
            indexTable.put(nums[curIdx] - target, curIdx);
        }
        return null;
    }
}
