class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] count = new long[101];
        for (int n : arr) {
            count[n]++;
        }
        double mod = 1E9 + 7;
        long res = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = i; j < 101; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) 
                    continue;
                if (i == j && j == k) {
                    res += count[i] * (count[j] - 1) * (count[k] - 2) / 6; // 3! = 6
                } else if (i == j && j != k) {
                    res += count[i] * (count[j] - 1) / 2 * count[k];
                } else if (j < k) {
                    res += count[i] * count[j] * count[k];
                }
            }
        }
        return (int) (res % mod);
    }
}