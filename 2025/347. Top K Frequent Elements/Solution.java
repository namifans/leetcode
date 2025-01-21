class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, (x, y) -> (y.getValue() - x.getValue()));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            heap.offer(e);
        }
        int[] freq = new int[k];
        while (!heap.isEmpty() && k > 0) {
            freq[k-- - 1] = heap.remove().getKey();
        }
        return freq;
    }
}