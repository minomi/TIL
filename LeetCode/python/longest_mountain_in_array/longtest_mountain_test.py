def longest_moutain(A):
    if len(A) < 3:
        return 0
    res = 0
    left = go_downhill(A)
    while left < len(A) - 1:
        right = left
        len_hill = 1
        if A[right] == A[right + 1]:
            left += 1
            continue
        while right < len(A) - 1 and A[right] < A[right + 1]:
            right += 1
            len_hill += 1
        while right < len(A) - 1 and A[right] > A[right + 1]:
            right += 1
            if len_hill > 1:
                len_hill += 1
                res = max(res, len_hill)
        left = right
    return res

def go_downhill(A):
    left = 0
    while left < len(A) - 1 and A[left] >= A[left + 1]:
        left += 1
    return left

def test_go_downhill():
    assert go_downhill([2, 1, 6]) == 1
    assert go_downhill([]) == 0


def test_longest_moutain():
    assert longest_moutain([1, 2]) == 0
    assert longest_moutain([1, 2, 3]) == 0
    assert longest_moutain([1, 2, 1]) == 3
    assert longest_moutain([2, 1, 4, 7, 3, 2, 5]) == 5
    assert longest_moutain([2, 2, 2]) == 0
    assert longest_moutain([1,2,3,2,1,2,3,4,5,4,3,2,1]) == 9 
    assert longest_moutain([0, 1, 2, 3, 2, 1, 0]) == 7 
    assert longest_moutain([2,1,4,7,3,2,1,5]) == 6 
    assert longest_moutain([0, 2, 2]) == 0 
    assert longest_moutain([2,3,3,2,0,2]) == 0 
