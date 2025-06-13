class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 2 for _ in range(n + 1)]
        for i in range(n - 1, -1, -1):
            for j in range(2):
                if j == 0:
                    dp[i][j] = dp[i + 1][1] - prices[i]
                else:
                    dp[i][j] = dp[i + 1][0] + prices[i]
                dp[i][j] = max(dp[i + 1][j], dp[i][j])
        return dp[0][0]