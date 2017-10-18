class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int l = 0, r = 0;
        while (r < nums.length) {
            while (nums[r] == 0 && r < nums.length - 1) {
                r++;
            }
            swap(nums, l, r);
            l++;
            r++;
        }
    }
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}