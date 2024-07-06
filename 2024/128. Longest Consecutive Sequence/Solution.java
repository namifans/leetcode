class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) 
            return nums.length;
        Arrays.sort(nums);
        int max = 1, con = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    con++;
                } else {
                    max = Math.max(con, max);
                    con = 1;
                }
            } 
        }
        return Math.max(con, max);
    }
}