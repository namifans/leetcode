class Solution {
    public int uniquePathsWithObstacles(int[][] obGrid) {
        int m = obGrid.length;
        int n = obGrid[0].length;
        int[][] r = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obGrid[i][0] == 1)
                break;
            r[i][0] =  1;
        }
        for (int j = 0; j < n; j++) {
            if (obGrid[0][j] == 1)
                break;
            r[0][j] =  1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obGrid[i][j] == 1)
                    continue;
                r[i][j] = r[i - 1][j] + r[i][j - 1];
            }
        }
        return r[m - 1][n - 1];
    }
}