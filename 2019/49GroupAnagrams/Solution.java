class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
            List<String> list = map.get(ns);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);
            map.put(ns, list);
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
}