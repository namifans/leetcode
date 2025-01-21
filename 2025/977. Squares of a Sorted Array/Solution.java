class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        int[] res = new int[nums.length];
        while (k >= 0) {
            int ii = nums[i] * nums[i];
            int jj = nums[j] * nums[j];
            if (ii > jj) {
                res[k] = ii;
                i++;
            } else {
                res[k] = jj;
                j--;
            }
            k--;
        }
        return res;
    }
}