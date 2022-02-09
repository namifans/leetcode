class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0, i = 0, j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] + k == nums[j]) {
                result ++;
                i++;
                while (i < nums.length && nums[i] == nums[i - 1]) i++;
            } else if (nums[i] + k < nums[j]) {
                i++;
            } else {
                j++;
            }
            while (j <= i) j++;
        }
        return result;
    }
}