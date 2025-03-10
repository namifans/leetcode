class Solution {

    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> sizeMap = new HashMap<>();
        int id = 2, max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int size = markIsland(grid, i, j, id);
                    sizeMap.put(id, size);
                    max = Math.max(max, size);
                    id++;
                }
            }
        }
        if (sizeMap.size() < 2)
            return max == grid.length * grid[0].length ? max : max + 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int size = expandIsland(grid, i, j, sizeMap);
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    private int markIsland(int[][] grid, int i, int j, int id) {
        int size = 0;
        grid[i][j] = id;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                size += markIsland(grid, x, y, id);
            }
        }
        return size + 1;
    }

    private int expandIsland(int[][] grid, int i, int j, Map<Integer, Integer> sizeMap) {
        int size = 1;
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > 1 && !set.contains(grid[x][y])) {
                size += sizeMap.get(grid[x][y]);
                set.add(grid[x][y]);
            }
        }
        return size;
    }
}