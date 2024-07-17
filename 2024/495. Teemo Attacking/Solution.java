class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int cur = -1, sec = duration;
        for (int i : timeSeries) {
            if (cur != -1) {
                if (i >= cur + duration) {
                    sec += duration;
                } else {
                    sec += i - cur;
                }
            }
            cur = i;
        }
        return sec;
    }
}