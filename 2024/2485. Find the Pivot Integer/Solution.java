class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int left = 0;
        for (int i = 1; i <= n; i++) {
            left += i;
            if (sum + i - left == left) {
                return i;
            }
        }
        return -1;
    }
}