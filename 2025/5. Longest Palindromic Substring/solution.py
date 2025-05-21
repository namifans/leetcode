class Solution:
    def longestPalindrome(self, s: str) -> str:
        long_start = long_end = 0
        def buildPalindrome(s: str, start: int, end: int) -> Tuple[int, int]:
            while start > 0 and end < len(s) - 1 and s[start - 1] == s[end + 1]:
                start -= 1
                end += 1
            return (start, end)
        
        for i in range(len(s)):
            odd_start, odd_end = buildPalindrome(s, i, i)
            if (odd_end - odd_start) > (long_end - long_start):
                long_start, long_end = odd_start, odd_end
            if i > 0 and s[i] == s[i - 1]:
                even_start, even_end = buildPalindrome(s, i - 1, i)
                if (even_end - even_start) > (long_end - long_start):
                    long_start, long_end = even_start, even_end

        return s[long_start:long_end + 1]