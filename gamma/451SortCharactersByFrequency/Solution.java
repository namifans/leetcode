class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            queue.offer(e);
        }
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> e = queue.poll();
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}