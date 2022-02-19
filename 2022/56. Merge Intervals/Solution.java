class Solution {
    public int[][] merge(int[][] intervals) {
        Queue<int[]> minHeap = new PriorityQueue<>(intervals.length, (x, y) -> Integer.compare(x[0], y[0]));
        for (int[] in : intervals) {
            minHeap.add(in);
        }
        List<int[]> list = new ArrayList<>();      
        while (!minHeap.isEmpty()) {
            if (list.isEmpty()) {
                list.add(minHeap.remove());
            } else {
                if (minHeap.peek()[1] <= list.get(list.size() - 1)[1]) {
                    minHeap.remove();
                } else if (minHeap.peek()[0] <= list.get(list.size() - 1)[1]) {
                    int[] in = list.remove(list.size() - 1);
                    in[1] = minHeap.remove()[1];
                    list.add(in);
                } else {
                    list.add(minHeap.remove());
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}