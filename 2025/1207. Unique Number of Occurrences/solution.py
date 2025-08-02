class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        count_map = Counter(arr)
        count_set = set()
        for key, val in count_map.items():
            if val in count_set:
                return False
            count_set.add(val)
        return True