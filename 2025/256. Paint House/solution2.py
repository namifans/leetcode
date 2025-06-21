class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp = [[float('inf')] * 3 for _ in range(n + 1)]
        dp[0] = [0, 0, 0]
        for i in range(1, n + 1):
            c = costs[i - 1]
            dp[i][0] = min(dp[i - 1][1] + c[0], dp[i -1][2] + c[0], dp[i][0])
            dp[i][1] = min(dp[i - 1][0] + c[1], dp[i -1][2] + c[1], dp[i][1])
            dp[i][2] = min(dp[i - 1][0] + c[2], dp[i -1][1] + c[2], dp[i][2])
        return min(dp[n])