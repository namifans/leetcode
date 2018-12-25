class Solution {
    public String reorganizeString(String S) {
        char[] arr = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            if (map.containsKey(c)) {
                if (map.get(c) + 1 > (arr.length + 1) / 2) {
                    return "";
                }
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(arr.length,
            new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            queue.offer(e);
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() >= 2) {
            Map.Entry<Character, Integer> e1 = queue.poll();
            Map.Entry<Character, Integer> e2 = queue.poll();
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == e1.getKey()) {
                sb.append(e2.getKey());
                sb.append(e1.getKey());
            } else {
                sb.append(e1.getKey());
                sb.append(e2.getKey());
            }
            requeue(e1, queue);
            requeue(e2, queue);
        }
        if (!queue.isEmpty()) {
            sb.append(queue.poll().getKey());
        }
        return sb.toString();
    }

    private void requeue(Map.Entry<Character, Integer> e, Queue queue) {
        if (e.getValue() > 1) {
            e.setValue(e.getValue() - 1);
            queue.offer(e);
        }
    }
}