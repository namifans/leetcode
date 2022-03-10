class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] x, int[] y) -> x[1] - y[1]);
        List<int[]> list = new ArrayList<>();
        int i = 1, count = 1, prevEnd = intervals[0][1];
        while (i < intervals.length) {
            if (intervals[i][0] >= prevEnd) {
                count++;
                prevEnd = intervals[i][1];
            }
            i++;
        }
        return intervals.length - count;
    }
}