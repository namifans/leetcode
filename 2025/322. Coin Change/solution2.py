class Solution(object):
    def coinChange(self, coins, amount):

        @lru_cache(maxsize=None)
        def getChange(coins, amount):
            change = float('inf')
            if amount == 0:
                return 0
            if amount < 0:
                return change
            for c in coins:
                change = min(change, getChange(coins, amount - c) + 1)
            return change
        change = getChange(tuple(coins), amount)
        return change if change != float('inf') else -1