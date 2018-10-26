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
        if (intervals.size() < 2)
            return intervals;
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int current = 0;
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > result.get(current).end) {
                result.add(intervals.get(i));
                current++;
            } else {
                if (result.get(current).end < intervals.get(i).end)
                    result.get(current).end = intervals.get(i).end;
            }
        }
        return result;
    }
}