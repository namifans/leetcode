class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        max_diff = -1
        cur_min = float('inf')
        for i in nums:
            if cur_min >= i:
                cur_min = i
            else:
                max_diff = max(i - cur_min, max_diff)
        return max_diff