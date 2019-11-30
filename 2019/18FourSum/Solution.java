class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            threeSum(nums, i, target - nums[i], result);
        }
        return result;
    }

    public void threeSum(int[] nums, int i1, int target, List<List<Integer>> result) {
        for (int i = i1 + 1; i < nums.length; i++) {
            if (i > i1 + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i1, i, target - nums[i], result);
        }
    }

    public void twoSum(int[] nums, int i1, int i2, int target, List<List<Integer>> result) {
        int i = i2 + 1, j = nums.length - 1;
        while (i < j) {
            if (i > i2 + 1 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result.add(new ArrayList<>(Arrays.asList(nums[i1], nums[i2], nums[i], nums[j])));
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}