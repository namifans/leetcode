class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j++] == nums[i++]) {
                return nums[i];
            }
        }
        return 0;
    }
}