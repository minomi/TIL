from collections import defaultdict

def top_k_frequent_elem(nums, k):
    cache = defaultdict(int)
    for n in nums:
        cache[n] += 1
    return sorted(cache, key=lambda k : cache[k] ,reverse = True)[:k]


def test_top_k_frequent_elem():
    assert top_k_frequent_elem([1], 1) == [1]
    assert top_k_frequent_elem([1,1,1,2,2,3], 2) == [1, 2]
