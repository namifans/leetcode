class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        mem = [[-1 for _ in range(len(text2))] for _ in range(len(text1))]

        def lcs_bf(t1, t2, i=0, j=0):
            if i == len(t1) or j == len(t2):
                return 0
            if mem[i][j] != -1:
                return mem[i][j]
            if t1[i] == t2[j]:
                mem[i][j] = lcs_bf(t1, t2, i + 1, j + 1) + 1
                return mem[i][j]
            mem[i][j] = max(lcs_bf(t1, t2, i + 1, j), lcs_bf(t1, t2, i, j + 1))
            return mem[i][j]

        return lcs_bf(text1, text2)