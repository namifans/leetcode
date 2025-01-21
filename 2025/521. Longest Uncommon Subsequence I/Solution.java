class Solution {
    public int findLUSlength(String a, String b) {
        if (a == null && b == null) {
            return -1;
        } else if (a == null || b == null) {
            return a == null ? b.length() : a.length();
        } else if (!a.equals(b)) {
            return Math.max(a.length(), b.length());
        } else
            return -1;
    }
}