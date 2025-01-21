class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] grid = new int[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int c = board[i][j] - '0';
                if (c == -2)
                    continue;
                int g = ((i / 3) * 3 + (j / 3));
                if (row[i][c] == c || col[j][c] == c || grid[g][c] == c) {
                    return false;
                }
                row[i][c] = c;
                col[j][c] = c;
                grid[g][c] = c;
            }
        }
        return true;
    }
}