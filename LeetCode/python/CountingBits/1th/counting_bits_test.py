def counting_bits(num):
    res = []
    for i in range(0, num + 1):
        res.append(counting_bit(i))
    return res


def counting_bit(num):
    res = 0
    while num != 0:
        num, mod = divmod(num, 2)
        if mod == 1:
            res += 1
    return res


def counting_bits_with_dp(num):
    dp = [0] * (num + 1)
    dp[1] = 1
    for i in range(2, num + 1):
        dp[i] = dp[i // 2] + i % 2
    return dp

def test_counting_bit():
    assert counting_bit(5) == 2 
    assert counting_bit(10) == 2 
    assert counting_bit(1) == 1 


def test_counting_bits():
    assert counting_bits(5) == [0,1,1,2,1,2]
    assert counting_bits(6) == [0,1,1,2,1,2,2]
    assert counting_bits_with_dp(5) == [0,1,1,2,1,2]
    assert counting_bits_with_dp(6) == [0,1,1,2,1,2,2]
