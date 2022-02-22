class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0, count = t.length(), mi = 0, mj = Integer.MAX_VALUE;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                if (map.get(s.charAt(j)) > 0) {
                    count--;
                }
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                while (count == 0) {
                    if (j - i < mj - mi) {
                        mi = i;
                        mj = j;
                    }
                    if (map.containsKey(s.charAt(i))) {
                        if (map.get(s.charAt(i)) + 1 > 0)
                            count++;
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    }
                    i++;
                }
            }
            j++;
        }
        return mj == Integer.MAX_VALUE ? "" : s.substring(mi, mj + 1);
    }
}
