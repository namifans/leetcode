class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int odd = 0;
        for (int i : map) {
            if (i % 2 != 0)
                odd ++;
        }
        return odd <= 1;
    }
}