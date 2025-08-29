class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        sliding_win = defaultdict(int)
        l, res = 0, 0
        for r in range(len(s)):
            ch = s[r]
            sliding_win[ch] += 1
            while len(sliding_win) > k:
                sliding_win[s[l]] -= 1
                if sliding_win[s[l]] == 0:
                    del sliding_win[s[l]]
                l += 1
            res = max(r - l + 1, res)
        return res