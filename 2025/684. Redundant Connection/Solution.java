class UnionFind {
    int[] parents;
    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return true;
        }
        parents[rootX] = rootY;
        return false;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] e : edges) {
            if (uf.union(e[0] - 1, e[1] - 1)) {
                return e;
            }
        }
        return new int[0];
    }
}