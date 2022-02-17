class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dis[i][j] = 0;     
                } else {
                    if (i > 0) {
                       dis[i][j] = Math.min(dis[i - 1][j] + 1, dis[i][j]);
                    }
                    if (j > 0) {
                       dis[i][j] = Math.min(dis[i][j - 1] + 1, dis[i][j]); 
                    }
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dis[i][j] = Math.min(dis[i + 1][j] + 1, dis[i][j]);
                }
                if (j < n - 1) {
                    dis[i][j] = Math.min(dis[i][j + 1] + 1, dis[i][j]); 
                }
            }
        }
        return dis;
    }
}