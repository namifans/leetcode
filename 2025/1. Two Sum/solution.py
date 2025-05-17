class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = defaultdict(int)
        for i in range(len(nums)):
            if (nums[i] in map):
                return map[nums[i]], i
            map[target - nums[i]] = i