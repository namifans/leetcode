class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        count_map = defaultdict(list)
        for s in strs:
            ana = tuple(sorted(s))
            count_map[ana] += [s]
        return [*count_map.values()]