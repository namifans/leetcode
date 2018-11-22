class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0)
            return result;
        Map<String, Integer> map = new HashMap<>();
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, 
            new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() != e2.getValue()) {
                    return e1.getValue() - e2.getValue();
                } else {
                    return e2.getKey().compareTo(e1.getKey());
                }
            };
        });
        for (String w : words) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            queue.add(e);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }
        return result;
    }
}