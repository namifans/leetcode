class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        next_empty, next_hold = 0, float('-inf') 
        for i in range(n - 1, -1, -1):
            cur_empty = max(next_empty, next_hold - prices[i])
            cur_hold = max(next_hold, next_empty + prices[i])
            next_hold, next_empty = cur_hold, cur_empty
        return next_empty