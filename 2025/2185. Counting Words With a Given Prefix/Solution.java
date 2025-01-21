class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                if (i >= pref.length() || pref.charAt(i) != w.charAt(i)) {
                    break;
                }
                if (i == pref.length() - 1)
                    count++;
            }
        }
        return count;
    }
}