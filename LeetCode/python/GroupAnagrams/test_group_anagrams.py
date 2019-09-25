def group_anagrams(strs):
    res = {}
    for s in strs:
        key = ''.join(sorted(s))
        if key in res:
            res[key].append(s)
        else:
            res[key] = [s]
    list_res = []
    for _, v in res.items():
        list_res.append(v)
    return list_res


def test_group_anagrams():
    assert group_anagrams(['abc']) == [['abc']]
