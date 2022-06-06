class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] g : grid) {
            int l = 0, r = g.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (g[m] >= 0) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            count += g.length - l;
        }
        return count;
    }
}