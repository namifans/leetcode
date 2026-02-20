class Solution {

    int start = 0, max = 0;

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            getPalindrome(i, i, arr);
            getPalindrome(i, i + 1, arr);
        }
        return s.substring(start, start + max);
    }

    private void getPalindrome(int left, int right, char[] arr) {
        while(left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        int len = right - left - 1;
        if (len > max) {
            start = left + 1;
            max = len;
        }
    }
}