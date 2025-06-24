class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        @lru_cache(maxsize=None)
        def traverse(i, j, k):
            if k == len(s3) and i == len(s1) and j == len(s2):
                return True
            found = False
            if k >= len(s3):
                return False
            if i < len(s1) and s1[i] == s3[k]:
                found |= traverse(i + 1, j, k + 1)
            if j < len(s2) and s2[j] == s3[k]:
                found |= traverse(i, j + 1, k + 1)
            return found
        return traverse(0, 0, 0)