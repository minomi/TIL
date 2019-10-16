def count_substrings(s):
    n = len(s)
    dp = [[False] * n for i in range(n)]
    res = 0
    for start in range(n - 1, -1, -1):
        dp[start][start] = True
        res += 1
        for end in range(start + 1, n):
            if end == start + 1 and s[start] == s[end]:
                dp[start][end] = True
                res += 1
            if end > start + 1 and dp[start + 1][end - 1] and s[start] == s[end]:
                dp[start][end] = True
                res += 1

    return res


def test_count_substrings():
    assert count_substrings('a') == 1
    assert count_substrings('aa') == 3
    assert count_substrings('ab') == 2
    assert count_substrings('aba') == 4

