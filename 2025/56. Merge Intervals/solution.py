class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals, key=lambda x: (x[0]))
        res, prev = [], intervals[0]
        for cur in intervals:
            if cur[0] > prev[1]:
                res.append([prev[0], prev[1]])
                prev = cur
            else:
                prev[1] = max(cur[1], prev[1])
        res.append(prev)
        return res