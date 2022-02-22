class Solution {
    public int fixedPoint(int[] arr) {
        int i = 0, j = arr.length - 1, ans = -1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (arr[m] == m) {
                ans = m;
                j = m - 1;
            } else if (arr[m] > m) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return ans;
    }
}