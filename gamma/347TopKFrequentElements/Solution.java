class Element {
    int num;
    int count;
    public Element(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0 || k == 0)
            return result;
        Map<Integer, Element> map = new HashMap<>();
        Queue<Element> queue = new PriorityQueue<>(k, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2) {
                return e1.count - e2.count;
            }
        });
        for (Integer i : nums) {
            Element e = map.get(i);
            if (e == null) {
                e = new Element(i, 0);
            }
            e.count++;
            map.put(i, e);
        }
        for (Map.Entry<Integer, Element> e : map.entrySet()) {
            queue.add(e.getValue());
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().num);
        }
        return result;
    }
}