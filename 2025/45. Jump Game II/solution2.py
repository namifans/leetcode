class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float('inf')] * (n)
        dp[-1] = 0
        for i in range(n - 2, -1, -1):
            max_jump = min(nums[i], n - i - 1)
            for j in range(1, max_jump + 1):
                dp[i] = min(dp[i + j] + 1, dp[i])
        return dp[0]