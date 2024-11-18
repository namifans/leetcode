class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l1 = word1.length(), l2 = word2.length();
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        if (i < word1.length())
            sb.append(word1.substring(i, l1));
        else
            sb.append(word2.substring(j, l2));
        return sb.toString();
    }
}