class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findMost(nums, k) - findMost(nums, k - 1);
    }

    private int findMost(int[] nums, int k) {
        int i = 0, j = 0;
        int odd = 0, count = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                odd++;
            }
            while (odd > k && i <= j) {
                if (nums[i] % 2 != 0) {
                    odd --;
                }
                i++;
            }
            j++;
            count += j - i + 1;
        }
        return count;
    }
}