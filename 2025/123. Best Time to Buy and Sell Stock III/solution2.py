class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[[0] * 2 for _ in range(3)] for _ in range(len(prices) + 1)]
        for i in range(len(prices) - 1, -1, -1):
            for r in range(1, 3):
                dp[i][r][0] = max(-prices[i] + dp[i + 1][r][1], dp[i + 1][r][0])
                dp[i][r][1] = max(prices[i] + dp[i + 1][r - 1][0], dp[i + 1][r][1])
        return dp[0][2][0]