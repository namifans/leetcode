class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j--] = t;
            } else {
                i++;
            }
        }
        return i;
    }
}