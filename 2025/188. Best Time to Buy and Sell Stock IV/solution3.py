class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        cost = [float('inf')] * (k + 1)
        profit = [0] * (k + 1)
        for price in prices: # expand buy and sell iii
            for i in range(1, k + 1):
                cost[i] = min(cost[i], price - profit[i - 1])
                profit[i] = max(profit[i],  price - cost[i])
        return profit[k]