class Solution {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;
        while (m <= r) {
            if (nums[l] == 0) {
                l++;
                if (m < l) {
                    m++;
                }
            } else if (nums[r] == 2) {
                r--;
            } else {
                if (nums[m] == 2) {
                    swap(nums, m, r--);
                } else if (nums[m] == 0) {
                    swap(nums, m, l++);
                } else {
                    m++;
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}