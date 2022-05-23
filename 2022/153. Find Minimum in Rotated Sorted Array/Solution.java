class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        if (nums.length == 1 || nums[l] < nums[h]) {
            return nums[l];
        }
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m > 1 && nums[m] < nums[m - 1]) {
                return nums[m];
            }
            if (m < nums.length - 1&& nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }
            if (nums[m] < nums[l]) {
                h = m - 1;    
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}