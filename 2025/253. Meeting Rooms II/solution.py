class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        min_heap = []
        res = 0
        for start, end in intervals:
            if min_heap and min_heap[0] <= start:
                heappop(min_heap)
            heappush(min_heap, end)
        return len(min_heap)