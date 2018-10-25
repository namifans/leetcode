class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0, d = 0;
        int[] dx = {0, 1, 0 , -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] map = new boolean[m][n];
        for (int k = 0; k < m * n; k++) {
            result.add(matrix[i][j]);
            map[i][j] = true;
            int ii = i + dx[d];
            int jj = j + dy[d];
            if (ii < 0 || ii == m || jj < 0 || jj == n || map[ii][jj]) {
                d = (d + 1) % 4;
            }
            i = i + dx[d];
            j = j + dy[d];
            
        }
        return result;
    }
}