import sys

def three_sum_closet(nums, target):
   nums.sort();
   n = len(nums);
   res = nums[0] + nums[1] + nums[2];
   for i in range(n - 2):
    s = i + 1;
    e = n - 1;
    while s < e:
        temp_res = nums[i] + nums[s] + nums[e];
        if temp_res == target:
            return temp_res;
        res = min(abs(target - temp_res), abs(target - res));
        if res > target:
            e -= 1;
        else:
            s += 1;
    return res;

if __name__ == '__main__':
    nums = [int(s) for s in sys.argv[1].split(',')];
    target = int(sys.argv[2]);
    print(three_sum_closet(nums, target));
