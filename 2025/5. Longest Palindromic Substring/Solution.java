class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = 0;
            len = panlindrome(i, i, arr);
            if (len > max) {
                start = i - len / 2;
                end = i + len / 2 + 1;
                max = len;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                len = panlindrome(i - 1, i, arr);
                if (len > max) {
                    start = i - len / 2;
                    end = i + len / 2;
                    max = len;
                }
            }
        }
        return s.substring(start, end);
    }

    private int panlindrome(int left, int right, char[] arr) {
        while (left > 0 && right < arr.length - 1) {
            if (arr[left - 1] == arr[right + 1]) {
                left--;
                right++;
            } else {
                break;
            }

        }
        return right - left + 1;
    }
}