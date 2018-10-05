class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int l = 0, r = l + 1;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                r++;
            } else {
                nums[l + 1] = nums[r];
                l++;
                r++;
            }
        }
        return l + 1;
    }
}