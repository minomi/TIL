def str_str(haystack, needle):
    # if not needle:
    #     return 0
    # for i, s in enumerate(haystack):
    #     if haystack[i:i + len(needle)] == needle:
    #         return i
    # return -1
    return haystack.find(needle)
