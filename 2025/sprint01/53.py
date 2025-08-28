class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_sum, max_sum = 0, float('-inf')
        for n in nums:
            cur_sum = max(n, cur_sum + n)
            max_sum = max(cur_sum, max_sum)
        return max_sum