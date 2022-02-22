class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] total = new int[cost.length + 1];
        total[0] = 0;
        total[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            total[i] = Math.min(total[i - 1] + cost[i - 1], total[i - 2] + cost[i - 2]);
        }
        return total[cost.length];
    }
}
