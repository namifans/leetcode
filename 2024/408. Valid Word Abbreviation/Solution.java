class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, loop = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (loop == 0 && abbr.charAt(j) == '0')
                    return false;
                else {
                    loop *= 10;
                    loop += abbr.charAt(j) - '0';
                    j++;
                }
            } else {
                while (loop > 0) {
                    i++;
                    loop--;
                }
                if (i >= word.length() || word.charAt(i++) != abbr.charAt(j++)) {
                    return false;
                } 
            }
        }
        return i == word.length() - loop && j == abbr.length();
    }
}