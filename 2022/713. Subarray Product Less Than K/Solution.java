class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1 || nums.length == 0)
            return 0;
        int i = 0, j = 0, prod = 1, count = 0;
        while (j < nums.length) {
            prod *= nums[j++];
            while (prod >= k) {
                prod /= nums[i++];
            }
            count += j - i;
        }
        return count;
    }
}