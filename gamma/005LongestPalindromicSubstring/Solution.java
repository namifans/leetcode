class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;
        char[] arr = s.toCharArray();
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            int len1 = getLongestPalindrome(arr, i, i);
            int len2 = getLongestPalindrome(arr, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return new String(arr, start, end - start + 1);
    }

    public int getLongestPalindrome(char[] arr, int start, int end) {
        while (start >= 0 && end < arr.length && arr[start] == arr[end]) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
