class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < ver1.length && j < ver2.length) {
            int c = Integer.valueOf(ver1[i++]).compareTo(Integer.valueOf(ver2[j++]));
            if (c != 0) {
                return c;
            }             
        }
        while (i < ver1.length) {
            if (Integer.valueOf(ver1[i++]) != 0) {
                return 1;
            }
        }
        while (j < ver2.length) {
            if (Integer.valueOf(ver2[j++]) != 0) {
                return -1;
            }
        }
        return 0;
    }
}