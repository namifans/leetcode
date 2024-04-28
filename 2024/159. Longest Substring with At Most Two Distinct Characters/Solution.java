class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int i = 0, j = 0, max = 0;
        while (j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j++], 0) + 1);
            if (map.size() > 2) {
                int k = map.get(arr[i]);
                if (k == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], k - 1);
                }
                i++;
            } 
            max = Math.max(max, j - i);
        }
        return max;
    }
}