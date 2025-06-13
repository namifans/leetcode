class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        jumps = cur_end = max_reach = 0
        for i in range(n - 1): # does not need to jump last
            max_reach = max(max_reach, i + nums[i])
            if i == cur_end:
                jumps += 1
                cur_end = max_reach
        return jumps