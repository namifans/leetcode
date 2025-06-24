class Solution:
    def minCostII(self, costs: List[List[int]]) -> int:
        n, k = len(costs), len(costs[0])
        dp = [[float('inf')] * k for _ in range(n)]
        dp[0] = costs[0][:]
        for i in range(1, n):
            for j in range(k):
                dp[i][j] = min(dp[i-1][x] for x in range(k) if x != j) + costs[i][j]
        return min(dp[-1])