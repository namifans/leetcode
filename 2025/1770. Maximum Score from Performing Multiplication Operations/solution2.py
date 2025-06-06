class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:
        
        n, m = len(nums), len(multipliers)

        @lru_cache(maxsize=None)
        def helper(left, right, ops):
            if ops == m:
                return 0
            mt = multipliers[ops]
            return max(
                nums[left] * mt + helper(left + 1, right, ops + 1),
                nums[right] * mt + helper(left, right - 1, ops + 1)
            )

        return helper(0, n - 1, 0)