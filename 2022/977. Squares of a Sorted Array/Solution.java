class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];
        for (int k = res.length - 1; k >=0; k--) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k] = nums[i] * nums[i++];
            } else {
                res[k] = nums[j] * nums[j--];
            }
        }
        return res;
    }
}