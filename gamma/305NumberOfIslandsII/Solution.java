class UnionFind {
    private int[] parent;
    private int count;
    public UnionFind(int m, int n, int[][] pos) {
        parent = new int[m * n];
        count = 0;
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
    public void addNode(int idx) {
        parent[idx] = idx;
        count++;
    }
    public int getCount() {
        return count;
    }
}

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> numOfIslands = new ArrayList<>();
        if (m == 0 && n == 0) {
            return numOfIslands;
        }
        UnionFind uf = new UnionFind(m, n, positions);
        int[][] grid = new int[m][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            uf.addNode(x * n + y);
            grid[x][y] = 1;
            for (int k = 0; k < 4; k++) {
                int xx = x + dx[k];
                int yy = y + dy[k];
                if (xx >= 0 && yy >= 0 && xx < m && yy < n && grid[xx][yy] == 1) {
                    uf.union(x * n + y, xx * n + yy);
                }
            }
            numOfIslands.add(uf.getCount());
        }
        return numOfIslands; 
    }
}