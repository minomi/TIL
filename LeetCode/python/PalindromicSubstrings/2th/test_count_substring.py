def count_substrings(s):
    dp = [[False] * len(s) for _ in range(len(s))]
    res = 0

    def inc(condition):
        nonlocal res
        if condition:
            res += 1

    for offset in range(len(s)):
        for i in range(len(s) - offset):
            if offset == 0:
                dp[i][i] = True
                inc(dp[i][i])
            elif offset == 1:
                dp[i][i + offset] = s[i] == s[i + offset]
                inc(dp[i][i + offset])
            else:
                dp[i][i + offset] = dp[i + 1][i + offset - 1] and s[i] == s[i + offset]
                inc(dp[i][i + offset])

    return res


def test_count_substrings():
    assert count_substrings("abc") == 3
    assert count_substrings("aaa") == 6
    assert count_substrings("ababa") == 9

