class Solution:
    def findLHS(self, nums: List[int]) -> int:
        count_map = Counter(nums)
        max_count = 0
        for key, val in count_map.items():
            if key + 1 in count_map:
                max_count = max(max_count, val + count_map[key + 1])
        return max_count