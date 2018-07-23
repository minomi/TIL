import unittest

def main():
    T = int(input())
    for t in range(T):
        X = input()
        arr = list(map(int, input().split()))
        print(solution(X, arr))

def solution(X, arr):
    max_sub = max_last = -1000
    for a in arr:
        max_last = max(0, max_last) + a
        max_sub = max(max_last, max_sub)
    return max_sub

class _10211Tests(unittest.TestCase):

    def test_solution(self):
        self.assertEqual(15, solution(5, [1, 2, 3, 4, 5]))
        self.assertEqual(4, solution(5, [2, 1, -2, 3, -5]))
        self.assertEqual(-1000, solution(1, [-1000]))


if __name__ == '__main__':
    # main()
    unittest.main()
