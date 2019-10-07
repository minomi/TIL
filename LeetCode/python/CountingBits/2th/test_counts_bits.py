def count_bits(num):
    res = [0] * (num + 1)
    for i in range(num + 1):
        res[i] = res[i // 2] + (0 if i % 2 == 0 else 1)
    return res


def test_count_bits():
    assert count_bits(2) == [0, 1, 1]
    assert count_bits(3) == [0, 1, 1, 2]
    assert count_bits(4) == [0, 1, 1, 2, 1]
    assert count_bits(5) == [0, 1, 1, 2, 1, 2]
    assert count_bits(6) == [0, 1, 1, 2, 1, 2, 2]
    assert count_bits(7) == [0, 1, 1, 2, 1, 2, 2, 3]
