def num_trees(n):
    dp = [0] * (n + 1)
    dp[0] = 1
    dp[1] = 1
    for num in range(2, n + 1):
        for i in range(num):
            dp[num] += (dp[num - (i + 1)] * dp[i])
    return dp[n]


def test_num_trees():
    assert num_trees(1) == 1
    assert num_trees(2) == 2
    assert num_trees(3) == 5
    assert num_trees(4) == 14
