def min_path_sum(grid):
    m, n = len(grid), len(grid[0])
    dp = [[0] * n for i in range(m)]
    dp[0][0] = grid[0][0]
    for i in range(1, n):
        dp[0][i] += dp[0][i - 1] + grid[0][i]
    for j in range(1, m):
        dp[j][0] += dp[j - 1][0] + grid[j][0]
    for c in range(1, m):
        for r in range(1, n):
            dp[c][r] = min(dp[c - 1][r], dp[c][r - 1]) + grid[c][r]
    return dp[m - 1][n -1]
def test_min_path_sum():
    assert min_path_sum([[1, 2], [1, 1]]) == 3
    assert min_path_sum([[1,3],[1,5],[4,2]]) == 8
