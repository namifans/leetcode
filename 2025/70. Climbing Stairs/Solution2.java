class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int last = 1, prev = 2;
        for (int i = 2; i < n; i++) {
            int current = prev + last;
            last = prev;
            prev = current;
        }
        return prev;
    }
}