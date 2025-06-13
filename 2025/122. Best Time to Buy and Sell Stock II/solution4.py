class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit, buy_price = 0, prices[0]
        for i in range(1, len(prices)):
            if prices[i] > buy_price:
                profit += prices[i] - buy_price
            buy_price = prices[i]
        return profit