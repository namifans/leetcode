class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE, w1 = -1, w2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (word1.equals(word2) && w1 != -1) {
                    min = Math.min(i - w1, min);
                }
                w1 = i;     
            } else if (wordsDict[i].equals(word2)) {
                w2 = i;
            }     
            if (w1 != -1 && w2 != -1) {
                min = Math.min(Math.abs(w1 - w2), min);
            }
        }
        return min;
    }
}