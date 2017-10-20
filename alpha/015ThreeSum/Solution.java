class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l] == nums[l - 1])
                continue;
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[l], nums[m], nums[r]}));
                    m++;
                    r--;
                    while (m < r && nums[m] == nums[m - 1]) {
                        m++;
                    }
                    while (m < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    m++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}