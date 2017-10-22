class Solution {

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        Queue<Point> queue = new LinkedList<>();
        Point org = new Point(start[0], start[1]);
        Point end = new Point(destination[0], destination[1]);
        queue.offer(org);
        distance[org.x][org.y] = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int count = 0;
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] != 1) {
                    x += dx[i];
                    y += dy[i];
                    count++;
                }
                x -= dx[i];
                y -= dy[i];
                if (distance[current.x][current.y] + count < distance[x][y]) {
                    distance[x][y] = distance[current.x][current.y] + count;
                    queue.offer(new Point(x, y));
                }
            }
        }
        if (distance[end.x][end.y] == Integer.MAX_VALUE)
            return -1;
        else
            return distance[end.x][end.y];
    }
}