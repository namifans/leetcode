class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = i * f[i - 1];
            nums.add(i);
        }
        k--;       
        for (int i = 1; i <= n; i++) {
            int c = k / f[n - i];
            result.append(nums.get(c));
            nums.remove(c);
            k -= c * f[n - i];
        }
        return result.toString();
    }
}