class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            if (j >= v2.length) {
                if (Integer.parseInt(v1[i++]) > 0)
                    return 1;
            } else if (i >= v1.length) {
                if (Integer.parseInt(v2[j++]) > 0)
                    return -1;
            } else {
                int c1 = Integer.parseInt(v1[i++]), c2 = Integer.parseInt(v2[j++]);
                if (c1 == c2)
                    continue;
                else
                    return c1 < c2 ? -1 : 1;
            }
        }
        return 0;
    }
}