class Solution {
    public int[][] insert(int[][] in, int[] ni) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        boolean inserted = false;
        while (i < in.length) {
            if (in[i][1] < ni[0]) {
                res.add(in[i]);
            } else if (in[i][0] > ni[1]) {
                if (!inserted) {
                    res.add(ni);
                    inserted = true;
                }
                res.add(in[i]);
            } else {
                ni[0] = Math.min(ni[0], in[i][0]);
                ni[1] = Math.max(ni[1], in[i][1]);
            }
            i++;
        }
        if (!inserted)
            res.add(ni);
        return res.toArray(new int[res.size()][2]);
    }
}