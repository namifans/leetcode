class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1}; 

    public int longestIncreasingPath(int[][] matrix) {
        int[][] paths = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longest = Math.max(longest, dfs(matrix, paths, i, j));
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int[][] paths, int i, int j) {    
        if (paths[i][j] != 0) {
            return paths[i][j];
        }
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[x].length && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, paths, x, y));
            }
        }
        paths[i][j] = max + 1;
        return max + 1;
    }
}