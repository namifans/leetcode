class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (i <= j && j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        return i;
    }
}