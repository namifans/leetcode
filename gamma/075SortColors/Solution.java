class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) 
            return;
        int l = 0, c = 0, r = nums.length - 1;
        while (l <= r && c <= r) {
            if (nums[c] == 0) {
                swap(nums, l++, c);
                if (nums[c] == 0) {
                    c++;
                }
            } else if (nums[c] == 2) {
                swap(nums, c, r--);
            } else {
                c++;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}