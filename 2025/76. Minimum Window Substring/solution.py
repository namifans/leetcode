class Solution:
    def minWindow(self, s: str, t: str) -> str:
        s_map, t_map = defaultdict(int), defaultdict(int)
        unique_count = current_count = 0
        short_count, start, end = float("inf"), 0, 0
        for c in t:
            if c not in t_map:
                t_map[c] = 0
                unique_count += 1
            t_map[c] += 1

        i = j = 0
        while j < len(s):
            rc = s[j]
            s_map[rc] += 1
            if  rc in t_map and t_map[rc] == s_map[rc]:
                current_count += 1
            while i <= j and current_count == unique_count:
                lc = s[i]
                if j - i + 1 < short_count:
                    short_count = j - i + 1
                    start = i
                    end = j
                if s_map[lc] == t_map[lc]:
                    current_count -= 1
                s_map[lc] -= 1
                i += 1
            j += 1

        return s[start:end+1] if short_count != float("inf") else ""