class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key=lambda x: (x[1]))
        erase, prev = 0, intervals[0][1]
        for i in range(1, len(intervals)):
            cur = intervals[i]
            if cur[0] < prev:
                erase += 1
            else:
                prev = cur[1]
        return erase