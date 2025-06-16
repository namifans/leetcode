class Solution:
    def maximumProduct(self, nums: List[int], m: int) -> int:
        n = len(nums)
        if n == 0:
            return 0
        if m == 1:
            return max(x * x for x in nums)
        max_prod = float('-inf')
        cur_max = cur_min = nums[0]
        for j in range(m - 1, n):
            cur_max = max(cur_max, nums[j - m + 1])
            cur_min = min(cur_min, nums[j - m + 1])
            max_prod = max(max_prod, cur_min * nums[j], cur_max * nums[j])        
        return max_prod