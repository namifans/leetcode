class Solution {   
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (!map.containsKey(c))
                continue;
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
            map.remove(c);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}