class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, i = 0, m = matrix.length, n = matrix[0].length;
        while (spiral.size() < m * n) {
            spiral.add(matrix[x][y]);
            matrix[x][y] = 101;
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= m || xx < 0 || yy >= n || yy < 0 || matrix[xx][yy] == 101) {
                i = (i + 1) % 4;
            }
            x = x + dx[i];
            y = y + dy[i];
        }
        return spiral;
    }
}