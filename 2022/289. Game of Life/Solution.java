class Solution {
    
    int[] dx = {0, 0, 1, 1 ,1, -1, -1 , -1};
    int[] dy = {1, -1, -1, 0, 1, -1, 0, 1};
    
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count1 = 0;
                for (int k = 0; k < 8; k++) {
                    int ii = i + dx[k];
                    int jj = j + dy[k];
                    if (ii >= 0 && ii < m && jj >= 0 && jj < n && (board[ii][jj] == 1 || board[ii][jj] == -1)) {
                        count1++;
                    }
                }
                if (board[i][j] == 0 && count1 == 3) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && (count1 > 3 || count1 < 2)) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (board[i][j] > 0) {
                     board[i][j] = 1;
                 } else {
                     board[i][j] = 0;
                 }
             }
        }
    }
}