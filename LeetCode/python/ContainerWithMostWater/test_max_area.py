def max_area(height):
    l, r, res = 0, len(height) - 1, 0
    while l < r:
        h = min(height[l], height[r])
        res = max(res, (r - l) * h)
        while height[l] <= h and l < r:
            l += 1
        while height[r] <= h and l < r:
            r -= 1
    return res


def test_max_area():
    assert max_area([1, 2]) == 1 
    assert max_area([1,8,6,2,5,4,8,3,7]) == 49 
    assert max_area([1,2,1]) == 2 
