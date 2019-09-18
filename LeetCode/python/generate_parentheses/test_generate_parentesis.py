def generate_parenthsus(n):
   res = []
   lefts = ['('] * n
   rights = [')'] * n
   backtracking(res, '', lefts, rights);
   return res


def backtracking(res, cur, lefts, rights):
    if not lefts:
        cur += ''.join(rights)
        res.append(cur)
        return

    if len(lefts) <= len(rights):
        n = lefts.pop()
        backtracking(res, cur + n, lefts, rights)
        lefts.append(n)

        n = rights.pop()
        backtracking(res, cur + n, lefts, rights)
        rights.append(n)

''' Leet code 다른 사람 좋은 답안
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 1: return ["()"]
        result = set()
        combinations = self.generateParenthesis(n-1)

        for c in combinations:
            for i in range(len(c)+1):
                result.add(c[:i] + "()" + c[i:])

        return result
'''

def test_generate_parenthsus():
    assert generate_parenthsus(1) == ['()']
    assert generate_parenthsus(2) == ['(())', '()()']
    assert generate_parenthsus(3) == ["((()))", "(()())", "(())()", "()(())",
  "()()()"]
