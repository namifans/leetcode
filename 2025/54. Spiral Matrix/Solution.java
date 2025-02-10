class Solution {

    int[][] dir = {{0, 1}, {1, 0}, {0 , -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0, count = 0;
        int n = matrix.length, m = matrix[0].length;
        while (count < n * m) {
            res.add(matrix[i][j]);
            if (checkBoundary(matrix, i + dir[k % 4][0], j + dir[k % 4][1])) {
                k++;
            }
            matrix[i][j] = -101;
            i += dir[k % 4][0];
            j += dir[k % 4][1];
            count++;
        }
        return res;
    }
    
    private boolean checkBoundary(int[][] matrix, int i, int j) {
        int n = matrix.length, m = matrix[0].length;
        return (i < 0) || (j < 0) ||
                (i >= n) || (j >= m) || 
                (matrix[i][j] == -101);

    }
}