def combination_sum(candidates, target):
    res = []
    candidates.sort()
    backtracking(candidates, target, res, [], 0)
    return res


def backtracking(candidates, target, res, temp_res, start):
    i[2,3,6,7]f target == 0:
        res.append(temp_res)
        return
    elif target < 0:
        return
    else:
        for i in range(start, len(candidates)):
            backtracking(candidates, 
                         target - candidates[i], 
                         res,
                         temp_res + [candidates[i]],
                         i)

def test_combination_sum():
    assert combination_sum([1], 1) == [[1]]
    assert combination_sum([2,3], 3) == [[3]]
    assert combination_sum([2,3,6], 5) == [[2, 3]]



