class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return new int[] {-1, -1};
        int first = searchFirst(nums, target);
        int last = searchLast(nums,target);
        return new int[] {first, last};
    }
    
    private int searchFirst(int[] nums, int target) {
        int res = -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
            if (nums[m] == target) {
                res = m;
            }
        }
        return res;
    }
    
    private int searchLast(int[] nums, int target) {
        int res = -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
            if (nums[m] == target) {
                res = m;
            }
        }
        return res;
    }
}