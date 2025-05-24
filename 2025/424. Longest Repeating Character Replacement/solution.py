class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        map = {}
        i = j = freq = res = 0
        while j < len(s):
            map[s[j]] = map.get(s[j], 0) + 1
            freq = max(freq, map[s[j]])
            if (j - i + 1 - freq > k):
                map[s[i]] = map.get(s[i]) - 1
                i += 1
            res = max(res, j - i + 1)
            j += 1
        return res