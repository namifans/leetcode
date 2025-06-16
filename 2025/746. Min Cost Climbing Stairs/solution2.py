class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        if n <= 1:
            return 0
        took2 = took1 = 0
        for i in range(2, n + 1):
            take = min(took2 + cost[i - 2], took1 + cost[i - 1])
            took2, took1 = took1, take
        return took1