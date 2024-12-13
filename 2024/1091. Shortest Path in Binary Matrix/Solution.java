class Path {
    int x;
    int y;
    int dis;
    public Path(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
class Solution {
    int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        int n = grid.length, m = grid[0].length;
        Queue<Path> q = new LinkedList<>();
        q.offer(new Path(0, 0, 1));
        grid[0][0] = 1;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Path p = q.remove();
            if (p.x == n - 1 && p.y == m - 1) {
                min = Math.min(min, p.dis);
                continue;
            }
            for (int i = 0; i < 8; i++) {
                int x = p.x + dx[i], y = p.y + dy[i];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1)
                    continue;
                grid[x][y] = 1;
                q.offer(new Path(x, y, p.dis + 1));
            }  
        }
        return min == Integer.MAX_VALUE ? -1 : min; 
    }
}