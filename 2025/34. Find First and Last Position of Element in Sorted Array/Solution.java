class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);
        int last = find(nums,target, false);
        return new int[]{first, last};
    }

    private int find(int[] nums, int target, boolean first) {
        int l = 0, r = nums.length - 1;
        int i = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                i = m;
                if (first) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return i;
    }
}