class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        @lru_cache(maxsize=None)
        def makeProfit(day, remain, holding):
            if day == n or remain == 0:
                return 0
            hold = makeProfit(day + 1, remain, holding)
            sell = buy = 0
            if holding:
                sell = makeProfit(day + 1, remain - 1, False) + prices[day]
            else:
                buy = makeProfit(day, remain, True) - prices[day]
            return max(sell, buy, hold)
        return makeProfit(0, 2, False)