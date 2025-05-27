class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        
        def bfs(grid: List[List[str]], pos: List[int]):
            queue = deque([pos])
            while queue:
                (i, j) = queue.popleft()
                if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or visited[i][j] or grid[i][j] != "1":
                    continue
                visited[i][j] = True
                for (x, y) in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    queue.append((i + x, j + y))

        island_count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and not visited[i][j]:
                    island_count += 1
                    bfs(grid, (i, j))
        return island_count