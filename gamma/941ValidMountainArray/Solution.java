class Solution {
    public boolean validMountainArray(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int i = 0;
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == nums.length - 1)
            return false;
        while (i < nums.length - 1 && nums[i] > nums[i + 1]) {
            i++;
        }
        return i == nums.length - 1;
    }
}