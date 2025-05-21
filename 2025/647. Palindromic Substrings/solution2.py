class Solution:
    def countSubstrings(self, s: str) -> int:
        length, total = len(s), 0
        for i in range(length):
            for l, r in [(i, i), (i, i + 1)]:
                while l >= 0 and r < length and s[l] == s[r]:
                    total += 1
                    l -= 1
                    r += 1
        return total
