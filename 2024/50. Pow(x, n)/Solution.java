class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n == 0) {
            return 1;
        }
        double p = 1.0;
        while (n != 0) {
            if (n % 2 != 0) {
                p *= x;
            }
            x *= x;
            n /= 2;
        }
        return p;
    }
}