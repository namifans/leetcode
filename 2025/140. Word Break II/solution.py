class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        word_set = set(wordDict)
        res = []
        def backtrack(start, cur):
            if start == len(s):
                res.append(" ".join(cur))
                return     
            for end in range(start, len(s)):
                if s[start:end + 1] in word_set:
                    cur.append(s[start:end + 1])
                    backtrack(end + 1, cur)
                    cur.pop()
        backtrack(0, [])
        return res