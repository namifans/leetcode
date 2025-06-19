class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        total_sum, min_sum, max_sum = 0, float('inf'), float('-inf')
        cur_max = cur_min = 0
        for num in nums:
            total_sum += num
            cur_max = max(num + cur_max, num)
            max_sum = max(cur_max, max_sum)
            cur_min = min(num + cur_min, num)
            min_sum = min(cur_min, min_sum)
        if total_sum == min_sum:
            return max_sum
            
        return max(max_sum, total_sum - min_sum)