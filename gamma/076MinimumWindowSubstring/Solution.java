class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char c : t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        count = map.size();
        char[] arr = s.toCharArray();
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, minLeft = 0;
        for (; r < arr.length; r++) {
            if (map.containsKey(arr[r])) {
                map.put(arr[r], map.get(arr[r]) - 1);
                if (map.get(arr[r]) == 0) {
                    count--;
                }
                while (count == 0) {
                    if (map.containsKey(arr[l])) {
                        if (map.get(arr[l]) + 1 <= 0) {
                            map.put(arr[l], map.get(arr[l]) + 1);
                            if (map.get(arr[l]) > 0)
                                count++;
                        } else {
                            if (r - l < minLen) {
                                minLeft = l;
                                minLen = r - l + 1;
                            }
                            break;
                        }
                    }
                    l++;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}