class Solution {

    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0)
            return points; 
        PriorityQueue<int[]> heap = new PriorityQueue<> (k, (int[] pt1, int[] pt2) -> (Integer.compare(pt2[2], pt1[2])));
        for (int[] p : points) {
            heap.offer(new int[] {p[0], p[1], p[0] * p[0] + p[1] * p[1]});
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int[][] res = new int[heap.size()][2];
        int i = 0;
        while (!heap.isEmpty()) {
            int[] pt = heap.remove();
            res[i++] = new int[] {pt[0], pt[1]};
        }
        return res;
    }
}