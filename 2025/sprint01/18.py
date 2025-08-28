class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if len(nums) < 4:
            return []
        nums = sorted(nums)
        res = []
        for i in range(len(nums) - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, len(nums) - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                two_sum = self.twoSum(nums[j + 1:], target - nums[i] - nums[j])
                for pair in two_sum:
                    res.append([nums[i], nums[j]] + pair)
        return res

    def twoSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        lo, hi = 0, len(nums) - 1
        while lo < hi:
            cur_sum = nums[lo] + nums[hi]
            if cur_sum < target:
                lo += 1
            elif cur_sum > target:
                hi -= 1
            else:
                res.append([nums[lo], nums[hi]])
                while lo < hi and nums[lo] == nums[lo + 1]:
                    lo += 1
                while lo < hi and nums[hi] == nums[hi - 1]:
                    hi -= 1
                lo += 1
                hi -= 1
        return res