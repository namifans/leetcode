class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        int j = i;
        while (j < intervals.length && intervals[j][0] <= newInterval[1]) {
            j++;
        }
        int min = i < intervals.length ? Math.min(intervals[i][0], newInterval[0]) : newInterval[0];
        int max = j - 1 >= 0 && j - 1 < intervals.length ? Math.max(intervals[j - 1][1], newInterval[1]) : newInterval[1];
        res.add(new int[]{min, max});
        while (j < intervals.length) {
            res.add(intervals[j++]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}