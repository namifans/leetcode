class Solution {
    public int arrangeCoins(int n) {
        int count = 0, row = 1;
        while (n > 0) {
            if (n < row) {
                return count;
            }
            n -= row++;
            count++;
        }
        return count;
    }
}