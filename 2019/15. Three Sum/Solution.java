class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) {
                continue;
            }
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                int t = nums[l] + nums[m] + nums[r];
                if (t == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[l], nums[m], nums[r])));
                    while (m < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    while (m < r && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    r--;
                    m++;
                } else if (t > 0) {
                    r--;
                } else {
                    m++;
                }
            }
        }
        return result;
    }
}