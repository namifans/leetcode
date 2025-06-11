class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        nums = nums + nums
        res, stack = [-1] * n, []
        for i in range(len(nums)):
            while stack and nums[stack[-1]] < nums[i]:
                j = stack.pop()
                res[j % n] = nums[i]
            stack.append(i)
        return res