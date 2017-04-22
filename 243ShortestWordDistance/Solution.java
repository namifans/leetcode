public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, dis = Integer.MAX_VALUE;
        for (int i = 0; i<words.length; i++) {
        	if (words[i].equals(word1))
        		w1 = i;
        	if (words[i].equals(word2))
        		w2 = i;
        	if (w1 != -1 && w2 != -1)
        		dis = Math.min(dis, Math.abs(w2 - w1));
        }
        return dis;
    }
}