class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        n = len(nums)
        if n % 3 != 0:
            return []
        nums = sorted(nums)
        res, tmp = [], []
        for num in nums:
            if tmp and tmp[0] + k < num:
                return []
            tmp.append(num)
            if len(tmp) == 3:
                res.append(tmp)
                tmp = []
        return res 