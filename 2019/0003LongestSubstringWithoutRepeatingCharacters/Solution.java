class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = 0, l = 0, r = 0;
        while (r < arr.length) {
            if (!set.contains(arr[r])) {
                set.add(arr[r]);
                max = Math.max(max, r - l + 1);
                r++;
            } else {
                set.remove(arr[l]);
                l++;
            }
        }
        return max;
    }
}