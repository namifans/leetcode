class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur, max_sum = 0, nums[0]
        for i in nums:
            cur += i
            if cur > max_sum:
                max_sum = cur
            if cur < 0:
                cur = 0
        return max_sum
