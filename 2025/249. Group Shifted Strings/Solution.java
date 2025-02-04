class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = calculate(s.toCharArray());
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> v : map.values()) {
            res.add(v);
        }
        return res;
    }

    private String calculate(char[] arr) {
        if (arr.length == 1)
            return ".";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            // + 26 and % 26 to avoid case like az and ba 
            int diff = (((arr[i] - 'a') - (arr[i - 1] - 'a')) + 26) % 26;  
            sb.append(diff).append(".");
        }
        return sb.toString();
    }
}