class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        cost1, cost2 = float('inf'), float('inf')
        profit1, profit2 = 0, 0
        for price in prices:
            cost1 = min(cost1, price)
            profit1 = max(profit1, price - cost1)
            cost2 = min(cost2, price - profit1)
            profit2 = max(profit2, price - cost2)
        return profit2