class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) ->  x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] in : intervals) {
            if (list.isEmpty()) {
                list.add(in);
            } else {
                int[] cur = list.get(list.size() - 1);
                if (in[0] >= cur[0] && in[1] <= cur[1]) {
                    continue;
                } else {
                    list.add(in);
                }
            }
        }
        return list.size();
    }
}