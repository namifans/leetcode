class Solution {

    private static String[] MEDAL = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        int[][] pairs = new int[score.length][2]; 
        for (int i = 0; i < score.length; i++) {
            pairs[i][0] = i;
            pairs[i][1] = score[i];
        }
        Arrays.sort(pairs, (x, y) -> (y[1] - x[1]));
        for (int i = 0; i < pairs.length; i++) {
            if (i >= MEDAL.length) {
                ranks[pairs[i][0]] = "" + (i + 1);
            } else {
                ranks[pairs[i][0]] = MEDAL[i];
            }
        }
        return ranks;
    }
}