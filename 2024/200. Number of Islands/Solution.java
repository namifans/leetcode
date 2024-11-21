class Solution {
    
    int dx[] = {0, 1, 0, -1};
    int dy[] = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    traverse(new int[]{i, j}, grid);
                }
            }
        }
        return count;  
    }

    private void traverse(int[] point, char[][] grid) {
        int x = point[0], y = point[1];
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1')
            return;
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            traverse(new int[]{x + dx[i], y + dy[i]}, grid);
        }
    }
}