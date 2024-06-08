class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int k = i + 1, j = nums.length - 1;
            while (k < j) {
                int m = k + (j - k) / 2;
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    Integer[] arr = new Integer[]{nums[i], nums[j], nums[k]};
                    res.add(Arrays.asList(arr));
                    while (k < j && nums[k] == nums[k + 1] ) {
                        k++;
                    }
                    while (k < j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    k++;
                    j--;
                } else if (sum > 0) {
                    j--;
                } else {
                    k++;
                }
            }
            i++;
        }
        return res;
    }
}