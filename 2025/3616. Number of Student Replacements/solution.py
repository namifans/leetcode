class Solution:
    def totalReplacements(self, ranks: List[int]) -> int:
        init, res = 0, 0
        for i in range(1, len(ranks)):
            if ranks[i] < ranks[init]:
                init = i
                res += 1
        return res