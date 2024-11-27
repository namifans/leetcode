class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        Queue<int[]> heap = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
        int max = 0, current = 0;
        for(int[] in : intervals) {
            if (!heap.isEmpty()) {
                if (heap.peek()[1] <= in[0]) {
                    heap.remove();
                }
            }  
            heap.offer(in);
            max = Math.max(max, heap.size());
        }
        return max;
    }
}