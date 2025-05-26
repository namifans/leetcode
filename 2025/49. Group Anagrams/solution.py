class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        count_map = defaultdict(list)
        for s in strs:
            m = defaultdict(int)
            for c in s:
                m[c] += 1
            key = tuple(sorted(m.items()))
            count_map[key] += [s]
        return [*count_map.values()]