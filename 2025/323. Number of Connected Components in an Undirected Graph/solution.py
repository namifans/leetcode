class UnionFind:
    def __init__(self, size):
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
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        unionfind = UnionFind(n)
        for (origin, dest) in edges:
            unionfind.union(origin, dest)
        return unionfind.size