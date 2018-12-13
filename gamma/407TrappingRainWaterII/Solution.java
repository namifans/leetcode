class Cell {
    int row;
    int col;
    int height;
    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        Queue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int water = 0;
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            queue.offer(new Cell(0, j, heightMap[0][j]));
            visited[m - 1][j] = true;
            queue.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }
        while(!queue.isEmpty()) {
            Cell c = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = c.row + dx[k];
                int y = c.col + dy[k];
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    water += Math.max(0, c.height - heightMap[x][y]);
                    queue.offer(new Cell(x, y , Math.max(c.height, heightMap[x][y])));
                }
            }
        }
        return water;
    }
}