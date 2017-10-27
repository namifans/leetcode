class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        String str = strs[0];
        int idx = 0;
        while (idx < str.length()) {
            for (int i = 1; i < strs.length; i++) {
                if (idx >= strs[i].length() || str.charAt(idx) != strs[i].charAt(idx))
                    return sb.toString();
            }
            sb.append(str.charAt(idx++));
        }
        return sb.toString();
    }
}