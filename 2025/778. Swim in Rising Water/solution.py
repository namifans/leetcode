class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        water = [[float('inf')] * m for _ in range(n)]
        water[0][0] = grid[0][0]
        heap = [(grid[0][0], 0, 0)]
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        while heap:
            cur_water, i, j = heappop(heap)
            if i == m - 1 and j == n - 1:
                return cur_water
            if cur_water < water[i][j]:
                continue
            for x, y in dirs:
                ni, nj = i + x, j + y
                if 0 <= ni < m and 0 <= nj < n:
                    next_water = max(grid[ni][nj], cur_water)
                    if next_water < water[ni][nj]:
                        heappush(heap, (next_water, ni, nj))
                        water[ni][nj] = next_water
        return water[m - 1][n - 1]