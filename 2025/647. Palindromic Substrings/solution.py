class Solution:
    def countSubstrings(self, s: str) -> int:
        total = 0
        def buildPalindrome(s: str, start: int, end: int) -> int:
            count = 0
            while start >= 0 and end < len(s) and s[start] == s[end]:
                count += 1
                start -= 1
                end += 1
            return count

        for i in range(len(s)):
            total += buildPalindrome(s, i, i)
            if i > 0 and s[i] == s[i - 1]:
                total += buildPalindrome(s, i - 1, i)
        
        return total
