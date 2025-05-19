class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        cur, longest = 0, 0
        for n in numSet:
            if n - 1 not in numSet:
                cur = 1
                while n + 1 in numSet:
                    cur += 1
                    n += 1
                if longest < cur: longest = cur
        return longest