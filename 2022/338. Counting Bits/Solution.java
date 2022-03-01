class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = getBit(i);
        }
        return ans;
    }
    
    private int getBit(int n) {
        int bit = 0;
        while (n != 0) {
            bit += n % 2;
            n /= 2;
        }
        return bit;
    }
}