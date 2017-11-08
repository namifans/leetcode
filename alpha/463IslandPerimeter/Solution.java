class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                int current = 0;
                for (int k = 0; k < 4; k++) {
                    int ii = i + di[k];
                    int jj = j + dj[k];
                    if (ii < 0 || jj < 0 || ii >= n || jj >= m) {
                        current++;
                        continue;
                    }
                    if (grid[ii][jj] == 0)
                        current++;
                }
                count += current;
            }
        }
        return count;
    }
}