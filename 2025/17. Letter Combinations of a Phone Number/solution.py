class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        keys_mapping = {
            "1": "",
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
        visited = set()
        def backtrack(index, s):
            if index >= len(digits):
                if s:
                    res.append(s)
                return
            key = keys_mapping[digits[index]]
            for ch in key:
                backtrack(index + 1, s + ch)
        res = []
        backtrack(0, "")
        return res