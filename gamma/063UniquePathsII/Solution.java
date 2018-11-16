class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)
                break;
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1)
                break;
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] != 1) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else {
                    f[i][j] = 0;
                }
            }
        }
        return f[m - 1][n - 1];
    }
}