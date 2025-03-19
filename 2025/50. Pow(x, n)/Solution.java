class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        double result = 1.0;
        while (N > 0) {
            if (N % 2 != 0) {
                result *= x;
                N--;
            }
            x *= x;
            N /= 2;
        }
        return result;
    }
}