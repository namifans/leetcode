class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                r++;
                continue;
            } 
            l++;
            nums[l] = nums[r];
            r++;
        }
        return l + 1;
    }
}