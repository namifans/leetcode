class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0)
            return "";
        int len = strs[0].length();
        int index = 0;
        while (index < len) {
            char current = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index || strs[i].charAt(index) != current) {
                    return sb.toString();
                }
            }
            sb.append(current);
            index++;
        }
        return sb.toString();
    }
}