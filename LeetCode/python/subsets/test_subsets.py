def subsets(nums):
    if not nums:
        return [[]]
    res = subsets(nums[:-1])
    for subset in res[:]:
        temp_sub = subset[:]
        temp_sub.append(nums[-1])
        res.append(temp_sub)
    return res


def test_subsets():
    assert subsets([1]) == [[], [1]]
    assert subsets([1,2]) == [[], [1], [2], [1,2]]
    assert subsets([1,2,3]) == [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
