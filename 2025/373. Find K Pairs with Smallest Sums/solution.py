class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        res, heap = [], []
        if not nums1 or not nums2:
            return res
        for i in range(min(k, len(nums1))):
            heapq.heappush(heap, (nums1[i] + nums2[0], i, 0))
        while heap and k > 0:
            (_, i, j) = heapq.heappop(heap)
            res.append((nums1[i], nums2[j]))
            k -= 1
            if j < len(nums2) - 1:
                heapq.heappush(heap, (nums1[i] + nums2[j + 1], i, j + 1))
        return res