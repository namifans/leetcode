class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
            new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    if (e1.getValue() == e2.getValue()) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return e2.getValue() - e1.getValue();
                    }
                }
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            heap.add(e);
        }
        List<String> list = new ArrayList<>();
        while (!heap.isEmpty() && k > 0) {
            list.add(heap.remove().getKey());
            k--;
        }
        return list;
    }
}