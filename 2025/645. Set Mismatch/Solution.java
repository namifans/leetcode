class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = 0, exp = 0, dup = 0;
        boolean[] map = new boolean[10002];
        for (int i = 0; i < nums.length; i++) {
            if (map[nums[i]]) 
                dup = nums[i];
            map[nums[i]] = true;
            sum += nums[i];
            exp += i + 1;
        }
        return new int[]{dup, exp + dup - sum};
    }
}