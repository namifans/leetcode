class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (upper < lower || (upper == lower && nums.length != 0)) {
            return result;
        } 
        int prev = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                result.add(getRange(prev, upper - 1));
                return result;
            }
            if (nums[i] > prev) {
                result.add(getRange(prev, nums[i] - 1));
            }
            prev = nums[i] + 1;
        }
        if (prev <= upper)
            result.add(getRange(prev, upper));
        return result;
    }

    private String getRange(long start, long end) {
        if (start == end) {
            return "" + start;
        } else {
            return start+ "->" + end;
        }
    }
}