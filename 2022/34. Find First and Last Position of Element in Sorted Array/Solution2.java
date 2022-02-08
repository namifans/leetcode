class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int i = 0, j = nums.length - 1;
        while (i < j && (nums[i] != target || nums[j] != target))  {
            int m = i + (j - i) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                if (nums[i] != target) i++;
                if (nums[j] != target) j--;
            }
        }
        if (i > j || (nums[i] != target && nums[j] != target)) {
            return res;
        }
        return new int[]{i, j};
    }
}