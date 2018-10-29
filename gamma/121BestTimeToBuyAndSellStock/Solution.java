class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int b = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > b) {
                max = Math.max(max, prices[i] - b);
            } else {
                b = prices[i];
            }
        }
        return max;
    }
}