class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board[0].length;
        int[][] row = new int[n + 1][n + 1];
        int[][] col = new int[n + 1][n + 1];
        int[][] cube = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                int c = board[i][j] - '0';
                if (row[i][c] != 0 || col[j][c] != 0 || cube[(i / 3) * 3 + j/3][c] != 0) {
                    return false;
                } 
                row[i][c] = c;
                col[j][c] = c;
                cube[(i / 3) * 3 + j/3][c] = c;
            }
        }
        return true;
    }
}