class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            heap.offer(e);
        }
        StringBuilder res = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> e = heap.poll();
            res.append(e.getKey()); 
            e.setValue(e.getValue() - 1);
            queue.offer(e);
            if (queue.size() < k) {
                continue;
            }
            Map.Entry<Character, Integer> entry = queue.poll();
            if (entry.getValue() > 0) {
                heap.offer(entry);
            }
        }
        return res.length() != s.length() ? "" : res.toString();
    }
}