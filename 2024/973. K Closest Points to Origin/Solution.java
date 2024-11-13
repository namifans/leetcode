class Point {
    public int x;
    public int y;
    public double dist;
    public Point(int x, int y, double dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0)
            return points; 
        PriorityQueue<Point> heap = new PriorityQueue<> (k, (pt1, pt2) -> (Double.compare(pt2.dist, pt1.dist)));
        for (int[] p : points) {
            double dist = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            Point pt = new Point(p[0], p[1], dist);
            heap.offer(pt);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int[][] res = new int[heap.size()][2];
        int i = 0;
        while (!heap.isEmpty()) {
            Point pt = heap.remove();
            res[i++] = new int[] {pt.x, pt.y};
        }
        return res;
    }
}