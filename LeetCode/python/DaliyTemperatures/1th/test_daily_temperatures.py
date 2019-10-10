def daily_temperatures(T):
    res, stack = [0] * len(T), []
    for i, t in enumerate(T):
        while stack and t > stack[-1][1]:
            idx, tem = stack.pop()
            res[idx] = i - idx
        stack.append((i, t))
    return res


def test_daily_temperatures():
    assert daily_temperatures([73, 74, 75, 71, 69, 72, 76, 73]) == [1, 1, 4, 2, 1, 1, 0, 0]
    assert daily_temperatures([]) == []

