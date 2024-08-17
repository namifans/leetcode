class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] c = q.remove();
            int x = c[0], y = c[1];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[x][i] = 0;
            }
        }
    }
}