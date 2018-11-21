class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int i = s.length - 1, j = t.length - 1;
        int cs = 0, ct = 0; 
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (s[i] == '#' || cs > 0)) {
                if (s[i] == '#') {
                    cs++;
                } else {
                    cs--;
                }
                i--;
            }
            while (j >= 0 && (t[j] == '#' || ct > 0)) {
                if (t[j] == '#') {
                    ct++;
                } else {
                    ct--;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && s[i] != t[j]) {
                return false;
            }
            i--;
            j--;
        }
        return i == j;
    }
}