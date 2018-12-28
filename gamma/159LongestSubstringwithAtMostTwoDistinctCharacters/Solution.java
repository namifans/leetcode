class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        char[] arr = s.toCharArray();
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0; j < arr.length; j++) {
            if (map.size() <= 2) {
                map.put(arr[j], j);
            }
            if (map.size() > 2) {
                for (Map.Entry<Character, Integer> e : map.entrySet()) {
                    if (j - e.getValue() >= 2) {
                        max = Math.max(max, j - e.getValue());
                        i = e.getValue() + 1;
                        map.remove(e.getKey());
                        break;
                    }
                }
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}