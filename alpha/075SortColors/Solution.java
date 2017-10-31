class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            while (nums[i] == 2 && i < right) {
                swap(nums, i, right--);
            }
            while (nums[i] == 0 && i > left) {
                swap(nums, i, left++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}