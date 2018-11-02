class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int left = 1, right = 1;
        int count = 1, limit = 2;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                count = 1;
                nums[left++] = nums[right];
            } else {
                if (count < limit) {
                    nums[left++] = nums[right];
                    count++;
                }
            }
            right++;
        }
        return left;
    }
}