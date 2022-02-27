class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        int t = n;
        while (t != 0) {
            int digit = t - t / 10 * 10;
            product *= digit;
            sum += digit;
            t /= 10;
        }
        return product - sum;
    }
}