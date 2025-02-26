class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean in = true, dec = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dec = false;
            } else if (nums[i] < nums[i - 1]) {
                in = false;
            }
            if (!dec && !in)
                return false;
        }
        return in || dec;
    }
}