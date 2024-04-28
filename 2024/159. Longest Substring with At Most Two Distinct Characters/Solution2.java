class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        int i = 0, j = 0, distinct = 0, max = 0;
        while (j < arr.length) {
            if (map[arr[j] - 'A'] == 0)
                distinct ++;
            map[arr[j] - 'A'] ++;
            if (distinct > 2) {
                map[arr[i] - 'A']--;
                if (map[arr[i] - 'A'] == 0) {
                    distinct--;
                }
                i++;
            } 
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}