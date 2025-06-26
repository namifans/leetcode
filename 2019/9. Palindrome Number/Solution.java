class Solution {
    public boolean isPalindrome(int x) {
        int r = 0, t = x;
        while (t > 0) {
            r += t - (t / 10 * 10);
            t /= 10;
            if (t > 0) {
              r *= 10;  
            }
        }
        return r == x;
    }
}