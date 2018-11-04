class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return A;
        int m = A.length, n = A[0].length;
        int len = (n % 2 == 0) ? n / 2 : (n / 2) + 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < len; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n - 1 - j] ^ 1;
                A[i][n - 1 - j] = temp ^ 1;
            }
        }
        return A;
    }
}