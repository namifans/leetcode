public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0, k = 31;
        while (k >= 0) {
            r += (n & 1) << k--;
            n >>= 1;
        }
        return r;
    }
}