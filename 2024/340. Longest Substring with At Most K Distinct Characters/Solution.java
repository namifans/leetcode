class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int i = 0, max = 0;
        for (int j = 0; j < arr.length; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (i <= j && map.size() > k) {
                if (map.get(arr[i]) == 1)
                    map.remove(arr[i]);
                else 
                    map.put(arr[i], map.get(arr[i]) - 1);
                i++;
            }
            max = Math.max(j - i + 1, max);
        }
        return max;
    }
}