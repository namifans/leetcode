class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dis = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (dis < min) {
                    min = dis;
                    idx = i;
                }
            }
        } 
        return idx;
    }
}