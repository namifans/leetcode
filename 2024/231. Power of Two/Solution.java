class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        while (n >= 2) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return n == 0 || n == 1;
    }
}