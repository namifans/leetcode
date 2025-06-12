class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False] * n
        for i in range(n):
            for word in wordDict:
                m = len(word)
                if i == m - 1 or (i > m - 1 and dp[i - m]):
                    if s[i - m + 1: i + 1] == word:
                        dp[i] = True
                        break
        return dp[-1]