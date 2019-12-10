class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        int n = matrix.length, m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int x = 0, y = 0, mode = 0;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        while (list.size() < n * m) {
            list.add(matrix[x][y]);
            visited[x][y] = true;
            int nx = x + dx[mode];
            int ny = y + dy[mode];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                mode = (mode + 1) % 4;
                x += dx[mode];
                y += dy[mode];
            }

        }
        return list;
    }
}