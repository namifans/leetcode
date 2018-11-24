class Solution {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] mapS = new int[10], mapG = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                bulls++;
            } else {
                mapS[s[i] - '0']++;
                mapG[g[i] - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(mapS[i], mapG[i]);
        }
        return bulls + "A" + cows + "B";
    }
}