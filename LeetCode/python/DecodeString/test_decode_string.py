def decode_string(s):
    num, st = "", [["", 1]]
    for c in s:
        if c.isdecimal():
            num += c
        elif c == '[':
            st.append(["", num])
            num = ""
        elif c == ']':
            temp, repeat = st.pop()
            st[-1][0] += int(repeat) * temp
        else:
            st[-1][0] += c
    return st[-1][0]


def test_decode_string():
    assert decode_string('3[a]') == 'aaa'
    assert decode_string('3[a]2[bc]') == 'aaabcbc'
    assert decode_string('3[a2[c]]') == 'accaccacc'

