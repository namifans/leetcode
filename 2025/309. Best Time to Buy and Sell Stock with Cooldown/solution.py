class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        n = len(prices)
        @lru_cache(maxsize=None)
        def makeProfit(day, cooldown, holding):
            if day == n:
                return 0
            hold = makeProfit(day + 1, False, holding)
            buy = sell = 0
            if cooldown:
                return makeProfit(day + 1, False, holding)
            if holding:
                sell = makeProfit(day + 1, True, False) + prices[day]
            else:
                buy = makeProfit(day + 1, False, True) - prices[day]
            return max(hold, buy, sell)

        return makeProfit(0, False, False)