class Solution {

    class UnionFind {
        int[] parent;
        int count = 0;

        public UnionFind(char[][] grid, int n, int m) {
            parent = new int[n * m];
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    parent[i * m + j] = i * m + j;
                    if (grid[i][j] == '1')
                        count++;
                }
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra != rb) {
                parent[ra] = rb;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(grid, n, m);
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0')
                    continue;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == '1') {
                        uf.union(i * m + j, x * m + y);
                    }
                }
            }
        }
        return uf.getCount();
    }
}