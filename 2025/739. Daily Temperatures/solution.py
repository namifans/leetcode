class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res, stack = [0] * len(temperatures), []
        for i,t in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < t:
                j = stack.pop()
                res[j] = (i - j)
            stack.append(i)
        return res