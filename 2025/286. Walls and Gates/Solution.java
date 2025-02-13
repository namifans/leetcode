class Solution {

    private static int WALL = -1;
    private static int GATE = 0;
    private static int ROOM = 2147483647;

    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;

    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length, m = rooms[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == GATE) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pt = queue.remove();
            int i = pt[0], j = pt[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k][0];
                int y = j + dir[k][1];
                if (x < 0 || y < 0 || x >= n || y >= m || rooms[x][y] != ROOM) {
                    continue;
                }
                rooms[x][y] = rooms[i][j] + 1;
                queue.add(new int[]{x, y});
            }
        }
    }
}