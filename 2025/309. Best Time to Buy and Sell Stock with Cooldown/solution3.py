class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        held = sold = float('-inf')
        cool = 0
        for p in prices:
            hold, sell = held, sold
            held = max(cool - p, held)
            sold = hold + p
            cool = max(cool, sell)
        return max(sold, cool)