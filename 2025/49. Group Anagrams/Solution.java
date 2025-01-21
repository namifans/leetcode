class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
            List<String> l = map.getOrDefault(ns, new ArrayList<>());
            l.add(s);
            map.put(ns, l);
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }
}