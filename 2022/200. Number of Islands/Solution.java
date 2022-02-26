class Solution {
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    searchIslands(grid, i, j);
                }
            }
        }
        return count;
    }
    
    //DFS
    private void searchIslands(char[][] grid, int i, int j) {
        
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] n = stack.pop();
            grid[n[0]][n[1]] = '0';
            for (int k = 0; k < 4; k++) {
                int x = n[0] + dx[k];
                int y = n[1] + dy[k];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
                    stack.add(new int[]{x, y});
                }
            }
        }
    }
}