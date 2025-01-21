class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(Arrays.asList(lower, upper));
            return res;
        }
        if (lower < nums[0]) {
            res.add(Arrays.asList(lower, nums[0] - 1));
        }
        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > last + 1) {
                res.add(Arrays.asList(last + 1, nums[i] - 1));       
            }
            last = nums[i];
        }
        if (last < upper) {
            res.add(Arrays.asList(last + 1, upper));
        }
        return res;
    }
}