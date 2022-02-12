class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        if (obstacleGrid[0][0] == 1)
            return 0;
        path[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) 
                break;
            path[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) 
                break;
            path[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                } else {
                    path[i][j] = 0;
                }
            }
        }
        return path[m - 1][n - 1];
    }
}