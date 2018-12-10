class UnionFind {
    private int[] parent;
    private int count;
    public UnionFind(char[][] grid, int n, int m) {
        count = 0;
        parent = new int[n * m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    parent[i * m + j] = i * m + j;
                    count++;
                }
            }
        }
    }
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            parent[rx] = ry;
            count--;
        }
    }
    public int getCount() {
        return count;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        UnionFind uf = new UnionFind(grid, n, m);
        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1}; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int ii = i + di[k];
                        int jj = j + dj[k];
                        if (ii >= 0 && jj >= 0 && ii < n && jj < m && grid[ii][jj] == '1') {
                            uf.union(i * m + j, ii * m + jj);
                        }
                    }
                }
            }
        }
        return uf.getCount();
    }
}