class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        res = []
        for i in range(0, len(s), k):
            st = s[i:i+k]
            if len(st) < k:
                st = st.ljust(k, fill)
            res.append(st)
        return res