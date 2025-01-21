class Solution {
    public int reverse(int x) {
        int r = 0, n = 1;
        if (x < 0) {
            n = -1;
            x = -x;
        }
        while (x > 0) {
            int t = x - (x / 10 * 10);
            r += t;
            if (x / 10 != 0) {
                if (r * 10 / 10 != r)
                    return 0;
                r *= 10;
            }
            x /= 10;
        }
        return r * n;
    }
}