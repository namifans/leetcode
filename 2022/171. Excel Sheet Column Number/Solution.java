class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
        }
        return res;
    }
}