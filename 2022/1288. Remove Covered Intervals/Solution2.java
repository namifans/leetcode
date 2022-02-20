class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;    
        }
        Arrays.sort(intervals, (x, y) ->  x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        int i = 0, j = 1, count = 1;
        while(j < intervals.length) {
            if (intervals[j][0] < intervals[i][0] || intervals[j][1] > intervals[i][1]) {
                i = j;
                count++;
            } 
            j++;
        }
        return count;
    }
}