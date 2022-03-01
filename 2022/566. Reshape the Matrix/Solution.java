class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (r * c != n * m)
            return mat;
        int[][] newMat = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMat[ (j + n * i) / c][(j + n * i) % c] = mat[i][j];
            }
        }
        return newMat;
    }
}