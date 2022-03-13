class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, String> cmap = new HashMap<>();
        Map<String, String> smap = new HashMap<>();
        String[] arr = str.split(" ");
        int i = 0;
        for (i = 0; i < arr.length && i < pattern.length(); i++) {
            String c = pattern.substring(i, i + 1);
            String s = arr[i];
            if (!cmap.containsKey(c) && !smap.containsKey(s)) {
                cmap.put(c, s);
                smap.put(s, c);
            }
            if (!c.equals(smap.get(s)) || !s.equals(cmap.get(c)))
                return false;
        }
        return (i < arr.length || i < pattern.length()) ? false : true;
    }
}