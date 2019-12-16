class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        if (og == null || og.length == 0 || og[0].length == 0)
            return 0;
        int n = og.length, m = og[0].length;
        int[][] f = new int[n][m];
        if (og[0][0] == 1) {
            return 0;
        }
        f[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (og[i][0] != 1) {
                f[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            if (og[0][i] != 1) {
                f[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (og[i][j] != 1) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[n - 1][m - 1];
    }
}