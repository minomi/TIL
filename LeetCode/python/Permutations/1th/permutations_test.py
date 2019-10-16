def permute(nums):
    res = [nums[0]]
    
    return res


def next_permutation(nums): 
    i = j = len(nums) - 1

    while i >= 0:
        if nums[i - 1] < nums[i]:
            break 
        i -= 1
    if i == 0:
        return []

    while j >= i:
        if nums[j] > nums[i - 1]:
            break
        j -= 1

    nums[i - 1], nums[j] = nums[j], nums[i - 1]
    res = nums[:i]
    res.extend(reversed(nums[i:]))
    return res


def test_next_permutation():
    assert next_permutation([1, 2, 3]) == [1, 3, 2]
    assert next_permutation([1, 3, 2]) == [2, 1, 3]
    assert next_permutation([2, 1, 3]) == [2, 3, 1]
    assert next_permutation([3, 2, 1]) == []
