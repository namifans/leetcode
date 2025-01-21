class Solution {
    public int dominantIndex(int[] nums) {
        int h = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[h] < nums[i]) {
                h = i;
            }
        }
        for (int i : nums) {
            if (nums[h] != i && nums[h] < i * 2) {
                return -1;
            }
        }
        return h;
    }
}