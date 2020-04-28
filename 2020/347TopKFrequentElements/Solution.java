class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>(k, (x, y) -> y - x);
        for (int i : nums) {
            Integer count = countMap.get(i);
            if (count == null) {
                count = 1;
            }
            countMap.put(i, count++);
        }
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            if (heap.size() < k) {
                heap.add(e.getValue());
            } else {
                if (heap.peek() < e.getValue()) {
                    heap.add(e.getValue());
                    heap.poll();
                }
            }
        }
        while(!heap.isEmpty()) {
            res[k--] = heap.poll();
        }
        return res; 
    }
}