from collections import Counter
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        dictS, dictT = defaultdict(int), defaultdict(int)
        for i in range(len(s)):
            dictS[s[i]] += 1
            dictT[t[i]] += 1
        return dictS == dictT
