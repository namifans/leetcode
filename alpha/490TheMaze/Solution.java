class Solution {

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int n = maze.length;
        int m = maze[0].length;
        Point org = new Point(start[0], start[1]);
        Point end = new Point(destination[0], destination[1]);
        boolean[][] visited = new boolean[n][m];
        queue.offer(org);
        visited[org.x][org.y] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = current.x;
                int y = current.y;
                while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] != 1) {
                    x += dx[i];
                    y += dy[i];
                } 
                x -= dx[i];
                y -= dy[i];
                if (!visited[x][y]) {
                    if (x == end.x && y == end.y) {
                        return true;
                    } else {
                        visited[x][y] = true;
                        queue.offer(new Point(x, y));
                    }
                }
            }
        }
        return false;
    }
}