class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, len = m * n;
        List<List<Integer>> list = new ArrayList<>();
        k %= len;
        int[][] res = new int[m][n];
        for (int i = 0; i < len; i++) {
            int x = i / n, y = i % n;
            int nx = ((i + k) % len) / n, ny = (i + k) % n;
            res[nx][ny] = grid[x][y];
        }
        for (int[] r : res) {
            list.add(Arrays.stream(r).boxed().collect(Collectors.toList()));
        }
        return list;
    }
}