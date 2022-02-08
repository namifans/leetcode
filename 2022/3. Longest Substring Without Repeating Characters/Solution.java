class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = i + 1;
        char[] arr = s.toCharArray();
        set.add(arr[i]);
        int max = set.size();
        while (j < arr.length) {
            if (set.contains(arr[j])) {
                set.remove(arr[i++]);
                continue;
            }
            set.add(arr[j++]);
            max = Math.max(max, set.size());
        }
        return max;
    }
}