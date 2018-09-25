class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        int[] map = new int[256];
        char[] arr = s.toCharArray();
        int j = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map[(int) arr[i]] == 0) {
                map[(int) arr[i]]++;
                if (i - j + 1 > max)
                    max = i - j + 1;
            } else {
                map[(int) arr[j]]--;
                j++;
                i--;
            }
        }
        return max;
    }
}