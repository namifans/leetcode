class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] arrWord = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, arrWord, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, char[] word, 
        int x, int y, int index, boolean[][] visited) {
        if (index == word.length)
            return true;
        if (x < 0 || y < 0 || x >= board.length 
            || y >= board[0].length || visited[x][y]
            || word[index] != board[x][y])
            return false;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (exist(board, word, x + dx[i], y + dy[i], index + 1, visited))
                return true;
        }
        visited[x][y] = false;
        return false;
    }
}