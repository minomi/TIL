package easy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-24.
 */

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        long maxSubSum = Integer.MIN_VALUE;
        long maxEnding = Integer.MIN_VALUE;

        for (int num : nums) {
            maxEnding = Long.max(maxEnding, 0) + num;
            maxSubSum = Long.max(maxSubSum, maxEnding);
        }

        return (int) maxSubSum;
    }
}
