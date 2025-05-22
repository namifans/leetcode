class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        max_neg = max_pos = max_product = nums[0]
        for n in nums[1:]:
            prev_pos = max_pos
            prev_neg = max_neg
            max_pos = max(n, prev_pos * n, prev_neg * n)
            max_neg = min(n, prev_pos * n, prev_neg * n)
            max_product = max(max_pos, max_neg, max_product)
        return max_product