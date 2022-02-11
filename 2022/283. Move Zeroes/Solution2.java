class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int nonzero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[nonzero++] = nums[i]; 
        }
        while (nonzero < nums.length) {
            nums[nonzero++] = 0;
        }
    }
}