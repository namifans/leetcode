class Solution {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int count = 0;
        int ones = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ones ++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty() && ones > 0) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] point = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dir[j][0];
                    int y = point[1] + dir[j][1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        ones--;
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        if (ones != 0) {
            return -1;
        }
        return count;
    }
}