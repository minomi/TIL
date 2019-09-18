def product_except_self(nums):
    mul = 1
    zero = set()
    res = []
    for i, n in enumerate(nums):
        if n == 0:
            zero.add(i)
            continue
        mul *= n
    if len(zero) >= 2:
        return [0] * len(nums)
    if not zero:
        for n in nums:
            res.append(mul // n)
    else:
        res = [0] * len(nums)
        for zero_idx in zero:
            res[zero_idx] = mul
    return res


def test_product_except_self():
    assert product_except_self([1,2,3,4]) == [24,12,8,6]
    assert product_except_self([0, 0]) == [0, 0]
    assert product_except_self([1, 0, 3]) == [0, 3, 0]
    assert product_except_self([1, 0, 3, 4]) == [0, 12, 0, 0]
    assert product_except_self([1, 0, 3, 0, 5]) == [0, 0, 0, 0, 0]
