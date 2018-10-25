class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = new ArrayList<>();
            if (map.containsKey(key)) {
                list = map.get(key); 
            }
            list.add(s);
            map.put(key, list);
        }
        for (List<String> l : map.values()) {
            result.add(l);
        }
        return result;
    }
}