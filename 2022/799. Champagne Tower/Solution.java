class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cups = new double[102][102];
        cups[0][0] = (double) poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double next = (cups[i][j] - 1) / 2;
                if (next > 0.0) {
                    cups[i + 1][j] += next;
                    cups[i + 1][j + 1] += next;
                }
            }
        }
        return cups[query_row][query_glass] > 1 ? 1 : cups[query_row][query_glass];
    }
}