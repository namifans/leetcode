class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] cur = intervals[0];
        list.add(cur);
        for (int[] i : intervals) {
            if (cur[1] >= i[0]) {
                cur[1] = Math.max(cur[1], i[1]);
            } else {
                cur = i;
                list.add(cur);
            } 
        }
        return list.toArray(new int[list.size()][]);
    }
}