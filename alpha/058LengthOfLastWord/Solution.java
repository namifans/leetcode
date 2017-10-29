class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0, idx = s.length() - 1;
        String[] strs = s.split(" ");
        if (strs.length > 0) {
            return strs[strs.length - 1].length();
        } else
            return 0;
    }
}