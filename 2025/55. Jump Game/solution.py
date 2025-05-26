class Solution:
    def canJump(self, nums: List[int]) -> bool:
        reach = nums[0]
        for i in range(1, len(nums)):
            if reach == 0:
                return False
            reach = max(reach - 1, nums[i])
        return True