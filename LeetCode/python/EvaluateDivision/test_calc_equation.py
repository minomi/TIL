def calc_equation(equations, values, queries):
    graph, edge_weight = {}, {}
    for i, eq in enumerate(equations):
        if eq[0] not in graph:
            graph[eq[0]] = []
            edge_weight[eq[0]] = []
        if eq[1] not in graph:
            graph[eq[1]] = []
            edge_weight[eq[1]] = []
        weight = values[i]
        graph[eq[0]].append(eq[1])
        graph[eq[1]].append(eq[0])
        edge_weight[eq[0]].append(weight)
        edge_weight[eq[1]].append(1 / weight)
    
    res = []

    for l, r in queries:
        if l not in graph or r not in graph:
            res.append(-1.0)
        elif l == r:
            res.append(1.0)
        else:
            res.append(dfs(graph, edge_weight, l, r, set(), 1.0))
    return res


def dfs(graph, edge_weight, start, dist, visits, weight):
    if start in visits:
        return -1.0
    if start == dist:
        return weight
    visits.add(start)
    nexts = graph[start]
    weights = edge_weight[start]
    tmp = 0.0
    for n, e  in zip(nexts, weights) :
        tmp = dfs(graph, edge_weight, n, dist, visits, weight * e)
        if tmp != -1.0:
            break
    return tmp

def test_calc_equation():
    assert calc_equation([['a', 'b'], ['b', 'c']],
                         [2.0, 3.0],
                         [['a', 'b']]) == [2.0]
    assert calc_equation([["a","b"],["b","c"]], 
                         [2.0,3.0],
                         [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]) == [6.00000, 0.50000, -1.00000, 1.0000, -1.0000]
