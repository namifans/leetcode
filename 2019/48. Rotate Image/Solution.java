class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int prev = matrix[i][j];
                for (int k = 0; k < 4; k++) {
                    int ii = j, jj = n - i - 1;
                    int tmp =  matrix[ii][jj];
                    matrix[ii][jj] = prev;
                    prev = tmp;
                    i = ii;
                    j = jj;
                }
            }
        }
    }
}

// i' = j, j' = n - i - 1;

// 0 0 - 0 2
// 0 2 - 2 2
// 2 2 - 2 0
// 2 0 - 0 0
    
// 0 1 - 1 2
// 1 2 - 2 1
// 2 1 - 1 0
// 1 0 - 0 1