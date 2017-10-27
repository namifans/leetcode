class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return -1;
        int min = Integer.MAX_VALUE, result = -1;
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1, right = nums.length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target){
                    mid++;
                } else {
                    right--;
                }
                if (Math.abs(target - sum) < min) {
                    result = sum;
                    min = Math.abs(target - sum);
                }
            }
        }
        return result;    
    }
}