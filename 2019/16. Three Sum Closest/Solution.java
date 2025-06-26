class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];
        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) {
                continue;
            }
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                int t = nums[l] + nums[m] + nums[r];
                if (t == target) {
                    return t;
                } else if (t < target) {
                    m++;
                } else {
                    r--;
                }
                if (Math.abs(target - t) < Math.abs(target - close)) {
                    close = t;
                }
            }
        }
        return close;
    }
}