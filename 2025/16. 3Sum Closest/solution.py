class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        diff, closest = float('inf'), 0
        for i in range(len(nums) - 2):
            j, k = i + 1, len(nums) - 1
            while j < k:
                cur_sum = nums[i] + nums[j] + nums[k]
                if cur_sum == target:
                    return cur_sum
                elif cur_sum < target:
                    j += 1
                else:
                    k -= 1
                cur_diff = abs(cur_sum - target)
                if cur_diff < diff:
                    diff = cur_diff
                    closest = cur_sum
        return closest