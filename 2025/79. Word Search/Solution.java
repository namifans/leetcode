class Solution {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {  
                if (search(board, i, j, word, 0))
                    return true;          
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int pos) {
        if (pos >= word.length() || word.charAt(pos) != board[i][j])
            return false;
        if (pos == word.length() - 1)
            return true;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (!isOutOfBoundary(board, x, y)) {
                if (search(board, x, y, word, pos + 1))
                    return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    private boolean isOutOfBoundary(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
            return true;
        return false;
    }
}