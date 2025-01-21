class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0, j = 0;
        int max = 0, high = 0;
        char[] arr = s.toCharArray();
        while (j < arr.length) {
            freq[arr[j] - 'A']++;
            high = Math.max(high, freq[arr[j] - 'A']);
            if (j - i + 1 - high > k) {
                freq[arr[i++] - 'A']--;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}