def unique_paths(m, n):
    dp = [[0] * m for i in range(n)]
    dp[0][0] = 1
    for i in range(m):
        dp[0][i] = 1
    for j in range(n):
        dp[j][0] = 1
    for row in range(1, n):
        for col in range(1, m):
            dp[row][col] = dp[row][col - 1] + dp[row - 1][col]
    return dp[n - 1][m - 1]

def test_unique_paths():
    assert unique_paths(3, 2) == 3
    assert unique_paths(7, 3) == 28
