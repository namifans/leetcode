class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int n = matrix.length; 
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2 + 1; j++) {
                int previous = matrix[i][j];
                for (int k = 0; k < 4; k++) {
                    int ii = j, jj = n - i - 1;
                    int temp = matrix[ii][jj];
                    matrix[ii][jj] = previous;
                    previous = temp;
                    i = ii;
                    j = jj;
                }
            }
        }
    }
}