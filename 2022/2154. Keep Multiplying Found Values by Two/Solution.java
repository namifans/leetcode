class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int i = original;
        while (set.contains(i)) {
            i *= 2;
        }
        return i;
    }
}