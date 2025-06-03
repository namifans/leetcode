class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def backtrack(n, left, right, s):
            if right > left or left > n or right > n:
                return
            if left == right == n:
                res.append(s)
                return
            backtrack(n, left + 1, right, s + "(")
            if (right < left):
                backtrack(n, left, right + 1, s + ")")
        backtrack(n, 0, 0, "")
        return res