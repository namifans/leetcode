class Solution {
    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            r += x - (x / 10 * 10);
            x /= 10;
            if (x != 0 && r * 10 / 10 != r) {
                return 0;
            }
            if (x != 0) {
                r *= 10;
            }
        }
        return r / 10;
    }
}