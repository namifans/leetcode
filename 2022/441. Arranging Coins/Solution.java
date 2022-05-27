class Solution {
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long sum = m * (m + 1) / 2;
            if (sum == n)
                return (int) m;
            else if (sum > n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) r;
    }
}