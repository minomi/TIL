def rotate(matrix):
    matrix.reverse()
    n = len(matrix)
    for y in range(n):
        for x in range(y, n):
            matrix[y][x], matrix[x][y] = matrix[x][y], matrix[y][x]

    return matrix


def test_rotate():
    assert rotate([[1, 2], [3, 4]]) == [[3, 1], [4, 2]]
    assert rotate([[1, 2, 3],
                   [4, 5, 6],
                   [7, 8, 9]]) == [[7,4,1],
                                   [8,5,2],
                                   [9,6,3]]
