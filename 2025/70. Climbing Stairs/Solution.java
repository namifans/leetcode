class Solution {
    public int climbStairs(int n) {
        int[] climb = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                climb[i] = 1;
            } else if (i == 1) {
                climb[i] = 2;
            } else {
                climb[i] = climb[i - 1] + climb[i - 2];
            }
        }
        return climb[n - 1];
    }
}