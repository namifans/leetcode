class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s_map, t_map = Counter(s1), defaultdict(int)
        i = j = 0
        while j < len(s2):
            lc, rc = s2[i], s2[j]
            if rc in s_map:
                t_map[rc] += 1
            while j - i + 1 > len(s1):
                if lc in s_map:
                    t_map[lc] -=  1
                i += 1
            if j - i + 1 == len(s1) and s_map == t_map:
                return True
            j += 1
        return False