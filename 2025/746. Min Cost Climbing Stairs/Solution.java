class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        int i = 2;
        while(i < cost.length) {
            minCost[i] = Math.min(minCost[i - 1], minCost[i - 2]) + cost[i++]; 
        }
        return Math.min(minCost[i - 1], minCost[i - 2]);
    }
}