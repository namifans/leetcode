class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        boolean[] set = new boolean[mat.length];
        int[] res = new int[k];
        int count = 0;
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (count < k && !set[i] && mat[i][j] == 0) {
                    res[count++] = i;
                    set[i] = true;
                }
            }
        }
        for (int i = 0; i < mat.length && count < k; i++) {
            if (!set[i]) {
                res[count] = i;
                count++;
            }
        }
        return res;
    }
}