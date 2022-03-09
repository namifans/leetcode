class Solution {
    public int countOrders(int n) {
        long mod = (long) 1e9 + 7;
        long[] count = new long[n + 2];
        count[1] = 1;
        count[2] = 6;
        for (int i = 3; i <= n; i++) {
            int space = (i - 1 ) * 2 + 1;
            long options = space * ((space + 1) / 2);
            count[i] = (count[i - 1] * options) % mod;
        }
        return (int) count[n];
    }
}
/*

   _ P1 _ D1 _ -> 3
   
   _ P1 _ D1 _ P2 _ D2 _ -> 5 - > (n - 1) * 2 + 1
   
   5 + 4 + 3 + 2 + 1 - > (5 + 1) / 2 -> s + 1 / 2

*/