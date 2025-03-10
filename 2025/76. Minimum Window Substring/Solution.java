class Solution {
    public String minWindow(String s, String t) {
        int[] sMap = new int[64];
        int[] tMap = new int[64];
        for (char c : t.toCharArray()) {
            tMap[c - 'A']++;
        }
        String res = "";
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        char[] arr = s.toCharArray();
        while (j < arr.length) {
            sMap[arr[j] - 'A'] ++;
            while (i <= j && isMapMatch(sMap, tMap)) {
                if (j - i + 1 < min) {
                    res = s.substring(i, j + 1);
                    min = res.length();
                }
                sMap[arr[i++] - 'A']--;
            }
            j++;
        }
        return res;
    }

    private boolean isMapMatch(int[] m1, int[] m2) {
        for (int i = 0; i < 64; i++) {
            if (m1[i] < m2[i])
                return false;
        }
        return true;
    }
}