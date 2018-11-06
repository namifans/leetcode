/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        if (intervals == null) {
            return result;
        }
        int pos = 0, start = newInterval.start, end = newInterval.end;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > newInterval.end) {
                result.add(intervals.get(i));
            } else if (intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
                pos++;
            } else {
                start = Math.min(intervals.get(i).start, start);
                end = Math.max(intervals.get(i).end, end);
            }
        }
        result.add(pos, new Interval(start, end));
        return result;
    }
}