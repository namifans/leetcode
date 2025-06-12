class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        dp = [[[0] * 2 for _ in range(k + 1)] for _ in range(len(prices) + 1)]

        for i in range(len(prices) - 1, -1, -1):
            for r in range(1, k + 1):
                for h in range(2):
                    hold = dp[i + 1][r][h]
                    sell = buy = 0
                    if h:
                        sell = prices[i] + dp[i + 1][r - 1][0]
                    else:
                        buy = -prices[i] + dp[i + 1][r][1]
                    dp[i][r][h] = max(hold, sell, buy)
        
        return dp[0][k][0]