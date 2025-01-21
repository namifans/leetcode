class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int r = 0, s = x;
        while (x != 0) {
            r += x - x / 10 * 10;
            x /= 10;
            if (x != 0) {
                if (r * 10 / 10 != r)
                    return false;
                r *= 10;
            }
        }
        return r == s;
    }
}