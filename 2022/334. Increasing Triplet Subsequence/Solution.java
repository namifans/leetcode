class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : nums) {
            first = Math.min(first, n);
            if (n > first) {
                second = Math.min(second, n);
            }
            if (n > second) {
                return true;
            }
        }
        return false;
    }
}