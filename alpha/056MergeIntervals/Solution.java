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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty())
            return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval last = null;
        for (Interval current : intervals) {
            if (last == null || current.start > last.end) {
                result.add(current);
                last = current;
            } else {
                if (last.end < current.end)
                    last.end = current.end;
            }
        }
        return result;
    }
}