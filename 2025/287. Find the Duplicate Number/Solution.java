class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] set = new boolean[nums.length];
        for (int i : nums) {
            if (set[i])
                return i;
            set[i] = true;
        }
        return -1;
    }
}