class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int current = Math.max(len1, len2);
            if (current > end - start) {
                start = i - (current - 1) / 2; // mid start pos = i
                end = i + current / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1; // end - 1 - (start + 1) + 1
    }
}