class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for s in stones:
            heappush(heap, -s)
        while len(heap) > 1:
            first, second = -heappop(heap), -heappop(heap)
            if first != second:
                heappush(heap, second - first)
        return -heap[0] if heap else 0