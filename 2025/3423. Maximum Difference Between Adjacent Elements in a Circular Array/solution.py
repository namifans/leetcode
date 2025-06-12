class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        diff = abs(nums[0] - nums[-1])
        for i in range(len(nums) - 1):
            diff = max(diff, abs(nums[i] - nums[i + 1]))
        return diff