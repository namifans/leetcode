class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        long l = 1, r = x / 2;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long s = m * m;
            if (s == x) {
                return (int) m;
            } else if (s < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (int) r;
    }
}