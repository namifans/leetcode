class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
            Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
            .thenComparing(Map.Entry<String, Integer>::getKey));
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            heap.offer(e);
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty() && res.size() < k) {
            res.add(heap.poll().getKey());
        }
        return res;
    }
}