
def biggerIsGreater(w):
    str_list = list(w)
    i = j = len(w) - 1

    while i > 0 and str_list[i - 1] >= str_list[i]:
        i -= 1

    if i == 0:
        return 'no answer'

    while j >= i and str_list[i - 1] >= str_list[j]:
        j -= 1

    str_list[i - 1], str_list[j] = str_list[j], str_list[i - 1]

    res = ''.join(str_list[:i] + list(reversed(str_list[i:])))

    return 'no answer' if res == w else res
