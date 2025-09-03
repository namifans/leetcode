class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        n = len(heights)
        stack = [0]
        res = [0] * n
        for i in range(1, len(heights)):
            while stack and heights[stack[-1]] < heights[i]:
                l = stack.pop()
                res[l] += 1
            if stack:
                res[stack[-1]] += 1
            stack.append(i)
        return res