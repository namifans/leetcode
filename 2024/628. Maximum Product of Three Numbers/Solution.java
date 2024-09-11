class Solution {
    public int maximumProduct(int[] nums) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int l = nums.length;
        int p1 = nums[l - 1] * nums[l - 2] * nums[l - 3];
        int p2 = 0;
        if (nums[0] < 0 && nums[1] < 0) {
            p2 = nums[0] * nums[1] * nums[l - 1];
        }
        return Math.max(p1, p2);
    }
}