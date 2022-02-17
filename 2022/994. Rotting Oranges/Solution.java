class Orange {
    public int x;
    public int y;
    public int gen;
    public Orange(int x, int y, int gen) {
        this.x = x;
        this.y = y;
        this.gen = gen;
    }
}

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
     
    public int orangesRotting(int[][] grid) {
        Queue<Orange> queue = new LinkedList<>();
        int fresh = 0, gen = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Orange(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        while (!queue.isEmpty()) {
            Orange o = queue.remove();
            int x = o.x;
            int y = o.y;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < grid.length && yy >=0 && yy < grid[0].length && grid[xx][yy] == 1) {
                    grid[xx][yy] = 2;
                    fresh--;
                    queue.add(new Orange(xx, yy, o.gen + 1));
                    gen = Math.max(gen, o.gen + 1);
                }
            }
        }
        if (fresh > 0)
            return -1;
        else
            return gen;
    }
}