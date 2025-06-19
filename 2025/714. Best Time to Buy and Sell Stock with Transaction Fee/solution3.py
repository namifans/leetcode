class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        cur_buy = cur_sell = 0
        for i in range(n - 1, -1, -1):
            prev_buy, prev_sell = cur_buy, cur_sell
            cur_sell = max(prev_buy + prices[i] - fee, prev_sell)
            cur_buy = max(prev_sell - prices[i], prev_buy)
        return cur_buy