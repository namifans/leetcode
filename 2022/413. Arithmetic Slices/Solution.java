class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) 
            return 0;
        int i = 2, count = 0, res = 0;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
                res += count;
            } else {
                count = 0;
            }
            i++;
        }        
        return res;
    }
}