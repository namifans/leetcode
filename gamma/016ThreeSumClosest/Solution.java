class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int l = 0; l < nums.length - 2; l++) {
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                if (Math.abs(target - sum) <= Math.abs(target - result))
                    result = sum;
                if (sum <= target) {
                    m++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}