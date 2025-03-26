class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length, sum = 0;
        int[] res = new int[2], map = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[grid[i][j] - 1] != 0) {
                    res[0] = grid[i][j];
                } else {
                    map[grid[i][j] - 1] = grid[i][j];
                }
                sum += grid[i][j];
            }
        }
        res[1] = (n * n * (n * n + 1) / 2) - sum + res[0];
        return res;
    }
}