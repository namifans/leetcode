class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        @lru_cache(maxsize=None)
        def makeProfit(day, holding):
            if day >= n:
                return 0
            hold = makeProfit(day + 1, holding)
            sell = buy = 0
            if holding:
                sell = makeProfit(day + 1, False) + prices[day]
            else:
                buy = makeProfit(day + 1, True) - prices[day]
            return max(sell, buy, hold)

        return makeProfit(0, False)