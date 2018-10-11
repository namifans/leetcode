class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[left] > target) 
            return 0;
        if (nums[right] < target) {
            return right + 1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return left;
    }
}