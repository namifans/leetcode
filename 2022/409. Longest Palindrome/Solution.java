class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c - 'A'] ++;
        }
        int len = 0;
        for (int i : map) {
            len += i / 2 * 2;
        }
        return len == s.length() ? len : len + 1;
    }
}