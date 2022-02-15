class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 0)
            return -1;
        int i = 0, j = i + 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            } else {
                j++;
            }
        }
        return i + 1;
    }
}
