class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)

        @lru_cache(maxsize=None)
        def jump_game(index):
            if index >= n - 1:
                return 0
            min_jump = float('inf')
            for i in range(1, nums[index]+ 1):
                new_jump = jump_game(index + i) + 1
                min_jump = min(min_jump, new_jump)
            return min_jump
            
        return jump_game(0) if n > 1 else 0