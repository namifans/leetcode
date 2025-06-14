class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        path_map = defaultdict(list)
        h = [[float('inf')] * n for _ in range(m)]
        heap = [(0, 0, 0)]
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        while heap:
            cur_h, cur_i, cur_j = heappop(heap)
            if cur_i == m - 1 and cur_j == n - 1:
                return cur_h
            if cur_h > h[cur_i][cur_j]:
                continue
            for (x, y) in dirs:
                ni, nj = cur_i + x, cur_j + y
                if 0 <= ni < m and 0 <= nj < n:
                    next_h = max(cur_h, abs(heights[ni][nj] - heights[cur_i][cur_j]))
                    if next_h < h[ni][nj]:
                        heappush(heap, (next_h, ni, nj))
                        h[ni][nj] = next_h
        return h[m - 1][n - 1]