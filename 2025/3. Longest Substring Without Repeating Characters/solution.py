class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        str_set = set()
        i, j, longest = 0, 0, 0
        while j < len(s):
            if s[j] in str_set:
                str_set.remove(s[i])
                i += 1
            else:
                str_set.add(s[j])
                j += 1
            if longest < j - i: longest = j - i
        return longest
