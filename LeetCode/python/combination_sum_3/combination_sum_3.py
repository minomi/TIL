

def combination_sum_3(k, n):
    res = []
    tmp = []

    limit = min(n, 10)

    def dfs(s):
        if len(tmp) == k:
            if sum(tmp) == n:
                res.append(list(tmp))
            return

        for i in range(s + 1, limit):
            tmp.append(i)
            dfs(i)
            tmp.pop()

        return

    for i in range(1, limit):
        tmp.append(i)
        dfs(i)
        tmp.pop()

    return res
