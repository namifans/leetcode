class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ('.' == board[i][j])
                    continue;
                int c = board[i][j] - '1';
                int b = (i / 3 ) * 3 + j / 3;
                if (row[i][c] > 0 || col[j][c] > 0 || block[b][c] > 0) {
                    return false;
                }
                row[i][c] ++;
                col[j][c] ++;
                block[b][c] ++;
            }
        }
        return true;
    }
}