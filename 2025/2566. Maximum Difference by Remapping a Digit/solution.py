class Solution:
    def minMaxDifference(self, num: int) -> int:
        s1, s2 = str(num), str(num)
        i = 0
        while i < len(s1) and s1[i] == "9":
            i += 1
        large = int(s1)
        if i < len(s1):
            large = int(s1.replace(s1[i], "9"))
        small = int(s2.replace(s2[0], "0"))
        return large - small