class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) 
            return 0;
        int n = costs.length;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green =costs[0][2];
        for (int i = 1; i < n; i++) {
            int curRed = Math.min(blue, green) + costs[i][0];
            int curBlue = Math.min(red, green) + costs[i][1];
            int curGreen = Math.min(red, blue) + costs[i][2];
            red = curRed;
            blue = curBlue;
            green = curGreen;
        }
        return Math.min(Math.min(red, blue), green);
    }
}