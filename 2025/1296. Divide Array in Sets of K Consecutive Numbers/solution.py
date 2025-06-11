class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        if n % k != 0:
            return False
        nums = sorted(nums)
        counter = Counter(nums)
        for i in nums:
            if not counter[i]:
                continue;
            counter[i] -= 1
            for j in range(1, k):
                if counter[i + j] <= 0:
                    return False
                counter[i + j] -= 1
        return True