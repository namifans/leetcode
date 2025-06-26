class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int l = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {
            int m = Math.max(maxPalindrome(arr, i, i + 1), maxPalindrome(arr, i, i)); 
            if (m > r - l) {
                l = i - (m - 1) / 2;
                r = i + m / 2;
            } 
        }
        return s.substring(l, r + 1);
    }

    public int maxPalindrome(char[] arr, int l, int r) {
        while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}