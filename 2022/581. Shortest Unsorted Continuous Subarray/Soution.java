class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] tmps = nums.clone();
        Arrays.sort(nums);
        int first = -1, last = - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != tmps[i] && first == -1) {
                first = i;
            }
            if (nums[nums.length - i - 1] != tmps[nums.length - i - 1] && last == -1) {
                last = nums.length - i - 1;
            }
        }
        if (first == -1 && last == -1) 
            return 0;
        else
            return last - first + 1;
    }
}