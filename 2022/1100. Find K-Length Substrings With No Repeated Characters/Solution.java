class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s == null || s.length() < 1 || k > s.length())
            return 0;
        int[] map = new int[26];
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            map[s.charAt(j) - 'a']++;
            if (map[s.charAt(j) - 'a'] > 1) {
                map[s.charAt(i++) - 'a']--;
                map[s.charAt(j) - 'a']--;
            } else {
                if (j - i + 1 == k) {
                    res++;
                    map[s.charAt(i++) - 'a']--;
                }
                j++; 
            }
        }
        return res;
    }
}