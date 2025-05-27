class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not intervals:
            return [newInterval]
        res = []
        new_start, new_end = newInterval
        for i, (start, end) in enumerate(intervals):
            if end < new_start:
                res.append([start, end])
            elif start > new_end:
                res.append([new_start, new_end])
                return res + intervals[i:]
            else:
                new_start = min(new_start, start)
                new_end = max(new_end, end)
        res.append([new_start, new_end])
        return res