class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        n = len(nums)
        if n % 3 != 0:
            return []
        nums = sorted(nums)
        res = []
        for i in range(0, n - 2, 3):
            if nums[i] + k < nums[i + 2]:
                return []
            res.append(nums[i:i+3])
        return res 