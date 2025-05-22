class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int prevMax = max, prevMin = min;
            max = Math.max(n, Math.max(prevMax * n, prevMin * n));
            min = Math.min(n, Math.min(prevMax * n, prevMin * n));
            res = Math.max(Math.max(max, min), res);
        }
        return res;
    }
}