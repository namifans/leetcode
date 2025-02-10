class Solution {
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int sum = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                sum += dfs(grid, x, y);
            }
        }
        return sum;
    }
}