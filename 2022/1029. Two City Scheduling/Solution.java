class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (int[] x, int[] y) -> (x[0] - y[0]));
        int n = costs.length / 2, a = 0;
        int[] b = new int[n * 2];
        for (int[] c : costs) {
            a += c[0];
        }
        for (int i = 0; i < 2 * n; i++) {
            b[i] = costs[i][1] - costs[i][0]; 
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            a += b[i];
        }
        return a;
    }
}
