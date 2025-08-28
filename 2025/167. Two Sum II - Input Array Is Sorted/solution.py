class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        lo, hi = 0, len(numbers) - 1
        while lo < hi:
            cur_sum = numbers[lo] + numbers[hi]
            if cur_sum < target:
                lo += 1
            elif cur_sum > target:
                hi -= 1
            else:
                return [lo + 1, hi + 1]
        return []