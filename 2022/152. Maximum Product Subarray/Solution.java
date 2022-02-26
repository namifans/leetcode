class Solution {
    public int maxProduct(int[] nums) {
        int pos = 1, neg = 1, max = Integer.MIN_VALUE;
        for (int n : nums) {
            int temp = pos;
            pos = Math.max(n, Math.max(neg * n, pos * n));
            neg = Math.min(n, Math.min(temp * n, neg * n));
            max = Math.max(max, Math.max(pos, neg));
        }
        return max;
    }
}