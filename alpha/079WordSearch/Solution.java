class Solution {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty())
            return true;
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            if (searchWord(board, next[0], next[1], word, 0))
                return true;
        }
        return false;
    }

    private boolean searchWord(char[][] board, int i, int j, String word, int index) {
        if (index >= word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        char c = board[i][j];
        if (c == word.charAt(index)) {
            board[i][j] = '#';
            for (int k = 0; k < 4; k++) {
                int ii = i + dx[k];
                int jj = j + dy[k];

                if (searchWord(board, ii, jj, word, index + 1))
                    return true;
            }
            board[i][j] = c;
        } 
        return false;
    }
}