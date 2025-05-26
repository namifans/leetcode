class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] x, int[] y) -> (x[0] - y[0]));
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for (int[] cur : intervals) {
            if (cur[0] > prev[1]) {
                res.add(new int[]{prev[0], prev[1]});
                prev = cur;
            } else {
                prev[1] = Math.max(cur[1], prev[1]);
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][2]);
    }
}