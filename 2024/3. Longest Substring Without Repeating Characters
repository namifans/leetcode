class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int res = 0, i = 0, j = 0;
        while (j < arr.length) {
            if (!set.contains(arr[j])) {
                set.add(arr[j++]);
            } else {
                set.remove(arr[i++]);
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}