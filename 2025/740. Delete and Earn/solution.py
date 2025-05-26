class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        dp = defaultdict(int)
        min_num, max_num = nums[0], nums[0]
        for n in nums:
            dp[n] += n
            max_num = max(max_num, n)
            min_num = min(min_num, n)
        for i in range(min_num, max_num + 1):
            dp[i] = max(dp[i] + dp[i - 2], dp[i - 1])
        return dp[max_num]