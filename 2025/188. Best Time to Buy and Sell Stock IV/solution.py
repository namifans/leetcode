class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        @lru_cache(maxsize=None)
        def makeProfit(day, remaining, holding):
            if remaining == 0 or day == len(prices):
                return 0
            hold = makeProfit(day + 1, remaining, holding)
            buy = sell = 0
            if holding:
                sell = prices[day] + makeProfit(day + 1, remaining - 1, False)
            else:
                buy = -prices[day] + makeProfit(day + 1, remaining, True)
            return max(hold, sell, buy)

        return makeProfit(0, k, False)