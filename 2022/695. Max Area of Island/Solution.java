class Solution {
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private int max = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    getArea(grid, i, j);
                }
            }
        }
        return max;
    }
    
    private void getArea(int[][] grid, int i, int j) {
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {i, j});
        int count = 0;
        while(!stack.isEmpty()) {
            int[] is = stack.pop();
            if (grid[is[0]][is[1]] == 0) continue;
            grid[is[0]][is[1]] = 0;
            count++;
            max = Math.max(max, count);
            for (int k = 0; k < 4; k++) {
                int x = is[0] + dx[k];
                int y = is[1] + dy[k];
                if (x >= 0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1) {
                    stack.push(new int[] {x, y});
                }
            }
        }
    }
}