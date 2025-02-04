class Solution {

    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, max = 0, flip = 0;
        while (j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else {
                if (flip == k) {
                    max = Math.max(max, j - i);
                    if (nums[i++] == 0) {
                        flip--;
                    }
                } else {
                    flip++;
                    j++;
                }
            }
        }
        return Math.max(max, j - i);
    }
}