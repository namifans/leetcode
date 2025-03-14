class Solution {
    public String minWindow(String s, String t) {
        char[] arr = s.toCharArray();
        int[] sMap = new int[64];
        int[] tMap = new int[64];
        int uniqueCount = 0;
        for (char c : t.toCharArray()) {
            if (tMap[c - 'A'] == 0)
                uniqueCount++;
            tMap[c - 'A']++;
        }
        int currentCount = 0, i = 0, j = 0, start = 0, end = 0, len = -1;
        while (j < arr.length) {
            sMap[arr[j] - 'A'] ++;
            if (tMap[arr[j] - 'A'] > 0 && tMap[arr[j] - 'A'] == sMap[arr[j] - 'A'])
                currentCount++;
            while (i <= j && currentCount == uniqueCount) {
                if (len == -1 || j - i + 1 < len) {
                    start = i;
                    end = j;
                    len = j - i + 1;
                }
                sMap[arr[i] - 'A']--;
                if (tMap[arr[i] - 'A'] > 0 && sMap[arr[i] - 'A'] < tMap[arr[i] - 'A'])
                    currentCount--;
                i++;
            }
            j++;
        }
        return len == -1 ? "" : s.substring(start, end + 1);
    }
}
   