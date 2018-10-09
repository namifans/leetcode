class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            if (nums[left] != val) {
                left++;
            } else if (nums[right] == val) {
                right--;
                count++;
            } else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
                count++;
            }
        }
        return nums.length - count;
    }
}