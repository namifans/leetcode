class Solution {
    public char findTheDifference(String s, String t) {
        char r = '\0';
        if (s == null || t == null) {
            return r;
        }
        int[] map = new int[26];
        for(char c : s.toCharArray()) {
            map[c - 'a'] ++;
        }
        for (char c: t.toCharArray()) {
            if (map [c - 'a'] < 1) {
                return c;
            } else {
                map [c - 'a'] --;
            }
        }
        return r;
    }
}