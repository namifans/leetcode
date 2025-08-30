class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        sliding_win = defaultdict(int)
        l, most_freq, res  = 0, 0, 0
        for r in range(len(s)):
            sliding_win[s[r]] += 1
            most_freq = max(most_freq, sliding_win[s[r]])
            while r - l + 1 - most_freq > k:
                sliding_win[s[l]] -= 1
                l += 1
            res = max(r - l + 1, res)
        return res