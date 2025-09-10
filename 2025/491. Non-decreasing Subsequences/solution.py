class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(index: int, curList: List[int]):
            if len(curList) >= 2:
                res.append(curList.copy())
            visited = set()
            for i in range(index, len(nums)):
                if nums[i] in visited:
                    continue
                if curList and nums[i] < curList[-1]:
                    continue
                visited.add(nums[i])
                curList.append(nums[i])
                backtrack(i + 1, curList)
                curList.pop()
        backtrack(0, [])
        return res