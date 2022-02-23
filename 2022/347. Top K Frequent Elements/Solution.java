class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer> > pq = new PriorityQueue<>(k, (x, y) -> (x.getValue() - y.getValue()));
        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] ans = new int[k];
        while(!pq.isEmpty()) {
            ans[k-- - 1] = pq.remove().getKey();
        }
        return ans;
    }
}