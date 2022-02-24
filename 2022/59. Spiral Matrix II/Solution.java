class Solution {
    public int[][] generateMatrix(int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] matrix = new int[n][n];
        int i = 0, j = 0, k = 0, spiral = 1;
        while(spiral <= n * n) {
            matrix[i][j] = spiral++;
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || y < 0 || x >= n || y >= n || matrix[x][y] != 0) {
                k = ++k % 4;
            } 
            i += dx[k];
            j += dy[k];
        }
        return matrix;
    }
}