class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((x, y) -> (x.value() - y.value()));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            heap.add(e);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        while (heap.isEmpty()) {
            res.add(heap.poll());
        }
        return res;
    }
}