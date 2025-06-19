class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        buy, sell = float('-inf'), 0
        for price in prices:
            buy = max(sell - price, buy)
            sell = max(buy + price - fee, sell)
        return sell