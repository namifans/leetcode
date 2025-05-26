class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur = max_sum = nums[0]
        for i in range(1, len(nums)):
            cur = max(cur + nums[i], nums[i])
            max_sum = max(max_sum, cur)
        return max_sum