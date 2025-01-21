class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, (x, y) -> (x.getValue() - y.getValue()));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            heap.offer(e);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int i = 0;
        int[] freq = new int[k];
        while (!heap.isEmpty()) {
            freq[i++] = heap.remove().getKey();
        }
        return freq;
    }
}