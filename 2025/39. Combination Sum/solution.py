class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def combination(candidates: List[int], target: int, current: List[int], pos: int):
            if target == 0:
                res.append(list(current))
                return
            for i in range(pos, len(candidates)):
                if (target - candidates[i] >= 0):
                    current.append(candidates[i])
                    combination(candidates, target - candidates[i], current, i)
                    current.pop()
        
        combination(candidates, target, [], 0)
        return res