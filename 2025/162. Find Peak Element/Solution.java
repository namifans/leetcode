class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m == 0) {
                return nums[m] > nums[m + 1] ? m : m + 1;
            } else if (m == nums.length - 1) {
                return nums[m] > nums[m - 1] ? m : m - 1;
            } else if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m] > nums[m + 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}