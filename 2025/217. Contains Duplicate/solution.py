class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        dupSet = set()
        for i in nums:
            if i in dupSet:
                return True
            dupSet.add(i)
        return False