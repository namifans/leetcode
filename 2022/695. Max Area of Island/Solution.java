class Island {
    public int x;
    public int y;
    public Island parent;
    public List<Island> neighbor = new ArrayList<>();
    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Island(int x, int y, Island p) {
        this.x = x;
        this.y = y;
        this.parent = p;
    }
}

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        Stack<Island> stack = new Stack<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    stack.push(new Island(i, j));
                }
            }
        }
        while(!stack.isEmpty()) {
            Island is = stack.pop();
            if (!visited[is.x][is.y]) {
                if (is.parent == null) {
                    is.parent = is;
                    is.neighbor.add(is);
                } else {
                    is.parent.neighbor.add(is);
                }
                max = Math.max(max, is.parent.neighbor.size());
                visited[is.x][is.y] = true;
                for (int k = 0; k < 4; k++) {
                    int xx = is.x + dx[k];
                    int yy = is.y + dy[k];
                    if (xx >= 0 && xx < m && yy >=0 && yy < n && !visited[xx][yy] && grid[xx][yy] == 1) {
                        stack.push(new Island(xx, yy, is.parent));
                    }
                }
            }
        }
        
        return max;
    }
}