class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 3, j = nums.length -2, k = nums.length - 1, max = 0;
        while (i >= 0) {
            if (nums[i] + nums[j] > nums[k]) {
                int p = nums[i] + nums[j] + nums[k];
                max = Math.max(p, max);
                return max;
            }
            i--;
            j--;
            k--;
        }
        return max;
    }
}