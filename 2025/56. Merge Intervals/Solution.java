class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 0)
            return intervals;
        if (intervals.length < 2)
            return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (int[] x, int[] y) -> (x[0] - y[0]));
        int i = 0, j = 1, start = intervals[0][0], end = intervals[0][1];
        while (j < intervals.length) {
            if (intervals[j][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[j][0];
                end = intervals[j][1];
            } else {
                end = Math.max(intervals[j][1], end);
            }
            j++;
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][2]);
    }
}