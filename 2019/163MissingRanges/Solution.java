class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (upper != lower) {
                result.add(lower + "->" + upper);
            } else {
                result.add(lower + "");
            }
            return result;
        }
        long prev = (long) lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            long after = (long) i == nums.length ? (long) upper + 1: nums[i];
            if (prev + 2 == after) {
                result.add((prev + 1) + "");
            } else if (prev + 2 < after) {
                result.add((prev + 1) + "->" + (after - 1));
            }
            prev = after;
        }
        return result;
    }
}
