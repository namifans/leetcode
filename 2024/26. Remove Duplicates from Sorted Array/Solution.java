class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = i + 1;
        while (i <= j && j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
            } else {
                nums[++i] = nums[j];
            } 
        }
        return i + 1;
    }
}