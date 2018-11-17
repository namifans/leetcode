class Solution {
    public int jump(int[] nums) {
        int current = 0, max = 0, jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == current) {
                jumps++;
                current = max;
            }
        }
        return jumps;
    }
}