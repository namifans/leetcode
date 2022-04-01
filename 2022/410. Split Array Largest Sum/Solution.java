class Solution {
    public int splitArray(int[] nums, int m) {
        int max = -1, sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        int l = max, r = sum;
        int minSum = sum;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (minSplitArray(nums, mid) <= m) {
                r = mid - 1;
                minSum = mid;
            } else {
                l = mid + 1;
            }
        }
        return minSum;
    }
    
    private int minSplitArray(int[] nums, int max) {
        int count = 1, sum = 0;
        for (int n : nums) {
            sum += n;
            if (sum > max) {
                sum = n;
                count++;
            }
        }
        return count;
    }
}
