class Solution {

    Map<Integer, List<String>> map = new HashMap();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    private List<String> wordBreak(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> result = new LinkedList();
        if (start == s.length()) {
            result.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end);
                for (String str : list) {
                    String toAdd = "";
                    if (!"".equals(str)) {
                        toAdd = " " + str;
                    }
                    result.add(s.substring(start, end) + toAdd);
                }
            }
        }
        map.put(start, result);
        return result;
    }
}