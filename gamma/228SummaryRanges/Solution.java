class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ranges;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j < nums.length - 1 && nums[j] == nums[j + 1] - 1)
                continue;
            if (i == j) {
                ranges.add("" + nums[i]);
            } else {
                ranges.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return ranges;
    }
}