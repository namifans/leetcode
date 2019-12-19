class DisjointSet {
    
    int[] p;
    int count;
    
    public DisjointSet(char[][] grid, int n, int m) {
        count = 0;
        p = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i * m + j] = i * m + j;
                if (grid[i][j] == '1')
                    count++;
            }
        }
    }
    
    public int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            count--;
            p[px] = py;
        }
    }
    
    public int count() {
        return count;
    }
}

class Solution {
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int n = grid.length, m = grid[0].length;
        DisjointSet ds = new DisjointSet(grid, n, m);
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int k = 0; k < 4; k++) {
                    int ii = i + dx[k];
                    int jj = j + dy[k];
                    if (ii >= 0 && ii < n && jj >= 0 && jj < m && grid[ii][jj] == '1') {
                        ds.union(i * m + j, ii * m + jj);
                    }
                } 
                }
            }
        }
        return ds.count();
    }
}