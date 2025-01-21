class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -10001, sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                double average = sum / k;
                max = Math.max(average, max);
                sum -= nums[i - k];   
            }
            sum += nums[i];
        }
        return Math.max(sum / k, max);
    }
}