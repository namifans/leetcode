class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int sb = 0, tb = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && s.charAt(i) == '#') {
                sb++;
                i--;
            } else if (j >= 0 && t.charAt(j) == '#') {
                tb++;
                j--;
            } else {
                if (sb > 0) {
                    sb--;
                    i--;
                } else if (tb > 0) {
                    tb--;
                    j--;
                } else {
                    if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                        i--;
                        j--;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}