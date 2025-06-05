class UnionFind:
    def __init__(self):
        self.parent = [i for i in range(26)]
    
    def find(self, x):
        if (self.parent[x] != x):
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)
        if root_x == root_y:
            return
        if root_x < root_y:
            self.parent[root_y] = self.parent[x]
        else:
            self.parent[root_x] = self.parent[y]

class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        unionfind = UnionFind()
        for c1, c2 in zip(s1, s2):
            i1, i2 = ord(c1) - ord('a'), ord(c2) - ord('a')
            unionfind.union(i1, i2)
        res = []
        for ch in baseStr:
            i = ord(ch) - ord('a')
            p = unionfind.find(i)
            res.append(chr(p + ord('a')))
        return "".join(res)