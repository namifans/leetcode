class WordDistance {

    Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> list = map.get(wordsDict[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(wordsDict[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            int x = l1.get(i), y = l2.get(j);
            min = Math.min(min, Math.abs(x - y));
            if (x < y) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */