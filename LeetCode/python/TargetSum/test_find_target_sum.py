def find_target_sum_ways(nums, S):
    cache = {}

    def find_target(i, s):
        if (i, s) in cache:
            return cache[(i, s)]
        if i == len(nums):
            if s == 0:
                return 1
            else:
                return 0
        cache[(i, s)] = find_target(i + 1, s + nums[i]) + find_target(i + 1, s - nums[i])
        return cache[(i, s)]

    return find_target(0, S)

def test_find_target_sum_ways():
    assert find_target_sum_ways([1, 1, 1], 1) == 3
    #assert find_target_sum_ways([1, 1, 1, 1, 1], 3) == 5


if __name__ == '__main__':
    print(find_target_sum_ways([1, 1, 1, 1, 1], 3));

