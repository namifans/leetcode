class UnionFind:
    def __init__(self, size: int):
        self.size = size
        self.parent = [i for i in range(size)]

    def find(self, x: int) -> int:
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int):
        root_x = self.find(x)
        root_y = self.find(y)
        if root_x != root_y:
            self.parent[root_x] = root_y
            self.size -= 1

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        unionfind = UnionFind(m * n)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    for (x,y) in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                        ii, jj = i + x, j + y
                        if ii >= 0 and jj >= 0 and ii < m and jj < n and grid[ii][jj] == "1":
                            unionfind.union(i * n + j, ii * n + jj)
                else:
                    unionfind.size -= 1
        return unionfind.size