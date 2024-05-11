class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1;
        for (int i : nums) {
            if (set.contains(-i)) {
                max = Math.max(max, Math.abs(i));
            }
            else {
                set.add(i);
            }
        }
        return max;   
    }
}