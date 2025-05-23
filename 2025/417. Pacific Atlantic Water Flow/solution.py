class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        n, m = len(heights), len(heights[0])
        pacific, atlantic, res = [], [], set()
        # get initial coordinates
        pacific = [(0, j) for j in range(m)] + [(i, 0) for i in range(n)]
        atlantic = [(n - 1, j) for j in range(m)] + [(i, m - 1) for i in range(n)]
        # bfs to search each coordinates water can flow through
        def bfs(queue: List[List[int]]) -> set():
            water_set = set()
            while queue:
                node = queue.pop()
                row, col = node[0], node[1]
                node_val = heights[row][col]
                water_set.add((row, col))
                for (x, y) in ((0,1),(1,0),(-1,0),(0,-1)):
                    i, j = row + x, col + y
                    if i < 0 or j < 0 or i >= n or j >= m:
                        continue
                    if (i, j) in water_set:
                        continue
                    if heights[i][j] < node_val:
                        continue
                    queue.append((i, j))
            return water_set
        # return intersection of pacific and atlantic
        return list(bfs(pacific).intersection(bfs(atlantic)))