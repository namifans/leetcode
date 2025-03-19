class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return helper(x, (long) n);
    }

    private double helper(double x, long n) {
        if (x == 0)
            return 0.0;
        if (n == 0)
            return 1.0;
        if (n % 2 == 1)
            return x * helper(x * x, (n - 1) / 2);
        else
            return helper(x * x, n / 2);
    }
}