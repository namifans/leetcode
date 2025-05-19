class Solution:
    def isPalindrome(self, s: str) -> bool:
        ch_list = "".join(c.lower() for c in s if c.isalnum())
        return ch_list == ch_list[::-1]