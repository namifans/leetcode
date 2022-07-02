class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == sum - nums[i] - prefix) {
                return i;
            }
            prefix += nums[i];
        }
        return -1;
    }
}