class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = deque()
        fresh_count = rotten_count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh_count += 1
        if fresh_count == 0:
            return 0
        while queue:
            next_set = set()
            oranges = []
            rotten_count += 1
            for _ in range(len(queue)):
                (i, j) = queue.popleft()
                for (x,y) in ((0,1),(0,-1),(1,0),(-1,0)):
                    ii, jj = i + x, j + y 
                    if (0 <= ii < len(grid) and 
                        0 <= jj < len(grid[0]) and
                        (ii, jj) not in next_set and
                        grid[ii][jj] == 1):
                        grid[ii][jj] = 2
                        fresh_count -= 1
                        queue.append((ii, jj))
        return rotten_count - 1 if not fresh_count else -1