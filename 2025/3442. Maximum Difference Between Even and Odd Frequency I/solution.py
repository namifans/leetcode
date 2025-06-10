class Solution:
    def maxDifference(self, s: str) -> int:
        max_odd, min_even = 0, float("inf")
        counter = Counter(s)
        for char, count in counter.items():
            if count % 2 == 0:
                min_even = min(min_even, count)
            else:
                max_odd = max(max_odd, count)
        return max_odd - min_even