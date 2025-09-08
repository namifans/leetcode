class Solution:
    def minOperations(self, s: str) -> int:
        char_map = [0] * 26
        for ch in s:
            char_map[ord(ch) - ord('a')] += 1
        max_count = 0
        for i in range(1, 26):
            if char_map[i] >= 1:
                max_count = i
                break
        return 26 - max_count if max_count != 0 else 0