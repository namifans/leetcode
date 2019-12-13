class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int i = 0, j = 0;
        while (i < h.length) {
            if (j == n.length) {
                return i;
            } else if (i + j >= h.length) {
                return -1;
            } else {
                if (h[i + j] == n[j]) {
                    j++;
                } else {
                    i++;
                    j = 0;
                }
            }
        }
        return -1;
    }
}