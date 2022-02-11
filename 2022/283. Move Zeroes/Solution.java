class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int z = 0, nz = 1;
        while (z < nums.length && nz < nums.length) {    
            if (nums[z] != 0) {
                z++;
                continue;
            }
            if (nums[nz] == 0 || nz < z) {
                nz++;
                continue;
            }
            if (z < nz) {
                int temp = nums[z];
                nums[z] = nums[nz];
                nums[nz] = temp;
            }
        }
    }
}