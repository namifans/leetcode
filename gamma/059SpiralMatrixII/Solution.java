class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int i = 0, j = 0, d = 0, current = 1;;
        for (int k = 0; k < n * n; k++) {
            matrix[i][j] = current++;
            int ii = i + di[d];
            int jj = j + dj[d];
            if (ii < 0 || ii == n || jj < 0 || jj == n || matrix[ii][jj] != 0) {
                d = (d + 1) % 4;
            }
            i += di[d];
            j += dj[d];
        }
        return matrix;      
    }
}