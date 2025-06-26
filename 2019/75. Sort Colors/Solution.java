class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k && i < nums.length - 1 && k >= 0) {
            if (nums[i] == 0) {
                i++;
                continue;
            } else if (nums[k] == 2) {
                k--;
                continue;
            }
            if (nums[j] == 0 && j > i) {
                swap(nums, i, j);
            } else if (nums[j] == 2 && j < k) {
                swap(nums, j, k);
            } else {
                j++;
            }            
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}