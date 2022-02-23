class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int n : prices) {
            min = Math.min(n, min);
            max = Math.max(max, n - min);
        }
        return max;
    }
}