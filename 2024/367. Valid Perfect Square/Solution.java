class Solution {
    public boolean isPerfectSquare(int num) {
        long i = 1, j = num;
        while (i <= j) {
            long k = (j - i) / 2 + i;
            if (k * k == num) {
                return true;
            } else if (k * k < num) {
                i = k + 1;
            } else {
                j = k - 1;
            }
        }
        return false;
    }
}