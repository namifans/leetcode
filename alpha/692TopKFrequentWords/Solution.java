class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0)
            return result;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int size = 1;
            if (map.containsKey(words[i])) {
                size += map.get(words[i]);
            }
            map.put(words[i], size);
        }
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(words.length, 
            new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue() == b.getValue()) {
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return b.getValue() - a.getValue();
                }
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        while (k-- > 0) {
            result.add(queue.poll().getKey());
        }
        return result;
    }
}