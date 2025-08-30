class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        l, cur_score, max_score = 0, 0, 0
        num_set = set()
        for r in range(len(nums)):
            while nums[r] in num_set:
                num_set.remove(nums[l])
                cur_score -= nums[l]
                l += 1
            cur_score += nums[r]
            num_set.add(nums[r])
            max_score = max(max_score, cur_score)
        return max_score