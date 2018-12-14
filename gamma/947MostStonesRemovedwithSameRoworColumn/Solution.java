class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            parent[rx] = ry;
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) 
            return 0;
        UnionFind uf = new UnionFind(2 * 10000);
        Set<Integer> set = new HashSet<>();
        for (int[] s : stones) {
            uf.union(s[0], s[1] + 10000);
        }
        for (int[] s : stones) {
            set.add(uf.find(s[0]));
        }
        return stones.length - set.size();
    }
}