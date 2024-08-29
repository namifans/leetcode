class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String[] strs = paragraph.replaceAll(
          "[^a-zA-Z0-9]", " ").split("\\s+");
        for (String s : banned) {
            map.put(s, -1);
        }
        for (String s : strs) {
            s = s.toLowerCase();
            if (map.containsKey(s) && map.get(s) == -1)
                continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        String res = "";
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > count) {
                count = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }
}