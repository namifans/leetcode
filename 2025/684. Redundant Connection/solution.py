class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)
        if root_x == root_y:
            return True
        self.parent[root_x] = root_y
        return False

class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        unionfind = UnionFind(len(edges))
        for a, b in edges:
            if unionfind.union(a - 1, b - 1):
                return [a,b]
        return []