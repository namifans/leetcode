class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                found |= findPath(board, i, j, 0, word, visited);
            }
        }
        return found;
    }
    
    private boolean findPath(char[][] board, int i, int j, int idx, String word, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || word.charAt(idx) != board[i][j])
            return false;
        boolean found = false;
        if (!visited[i][j]) {
            visited[i][j] = true;
            found = findPath(board, i + 1, j, idx + 1, word, visited) || 
                findPath(board, i - 1, j, idx + 1, word, visited) ||
                findPath(board, i, j + 1, idx + 1, word, visited) ||
                findPath(board, i, j - 1, idx + 1, word, visited);
            visited[i][j] = false;
        }
        return found;
    }
}