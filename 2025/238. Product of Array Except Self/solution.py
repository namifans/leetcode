class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [1] * n
        product = 1
        for i in range(1, n):
            product = product * nums[i - 1]
            res[i] = product
        product = 1
        for i in range(n - 2, -1, -1):
            product *= nums[i + 1]
            res[i] *= product
        return res