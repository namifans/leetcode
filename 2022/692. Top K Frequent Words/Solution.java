class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String s : words) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, (x, y) -> {
           if (x.getValue().equals(y.getValue())) {
               return y.getKey().compareTo(x.getKey());
           } else {
               return x.getValue().compareTo(y.getValue());
           }
        });
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            queue.offer(e);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        List<String> res = new ArrayList<>();
        while (k > 0) {
            res.add(0, queue.remove().getKey());
            k--;
        }
        return res;
    }
}