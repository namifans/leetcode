class Solution:
    def bowlSubarrays(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return 0
        count, n = 0, len(nums)
        stack = []
        for j in range(n):
            while stack and nums[stack[-1]] <= nums[j]:
                i = stack.pop()
                if j - i + 1 >= 3:
                    count += 1
            if stack and j - stack[-1] + 1 >= 3:
                count += 1
            stack.append(j)
        return count