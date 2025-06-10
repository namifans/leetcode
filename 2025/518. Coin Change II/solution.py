class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        coins = tuple(sorted(coins))
        @lru_cache(maxsize=None)
        def get_change(amount, i):
            if amount == 0:
                return 1
            if amount < 0 or i >= len(coins):
                return 0
            return get_change(amount - coins[i], i) + get_change(amount, i + 1)
        
        return get_change(amount, 0)
