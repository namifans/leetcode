class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        filtered_nums = [nums[0]] + [nums[i] for i in range(1, len(nums)) if nums[i] != nums[i - 1]]
        count = 0
        for i in range(1, len(filtered_nums) - 1):
            prev, cur, nxt = filtered_nums[i - 1], filtered_nums[i], filtered_nums[i + 1]
            if prev < cur > nxt or prev > cur < nxt:
                count += 1
        return count