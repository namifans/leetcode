class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        @lru_cache(maxsize=None)
        def findProfit(day, holding):
            if day >= n:
                return 0
            hold = findProfit(day + 1, holding)
            sell = buy = 0
            if holding:
                sell = findProfit(day + 1, False) + prices[day] - fee
            else:
                buy = findProfit(day + 1, True) - prices[day]
            return max(hold, sell, buy)
        return findProfit(0, False)