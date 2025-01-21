class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (int[] x, int[] y) -> (x[0] - y[0]));
        int i = 0, j = 1;
        while (j <= intervals.length) {
            if (j == intervals.length || intervals[j][0] > intervals[i][1]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                i = j;
            } else {
                intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
            }
            j++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}