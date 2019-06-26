import bigger_is_greator


def test_combination_sum_3():
    assert 'acbd' == bigger_is_greator.biggerIsGreater('abdc')
    assert 'no answer' == bigger_is_greator.biggerIsGreater('bb')
    assert 'no answer' == bigger_is_greator.biggerIsGreater('dcba')
    assert 'no answer' == bigger_is_greator.biggerIsGreater('dcbb')
