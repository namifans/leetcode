class Solution {
    int res;

    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>(), diagonal = new HashSet<>(), rediagonal = new HashSet<>();
        dfs(col, diagonal, rediagonal, 0, n);
        return res;
    }

    private void dfs(Set<Integer> col, Set<Integer> diagonal, Set<Integer> rediagonal, int r, int n) {
        if (r == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diagonal.contains(r - i) || rediagonal.contains(r + i))
                continue;
            col.add(i);
            diagonal.add(r - i);
            rediagonal.add(r + i);
            dfs(col, diagonal, rediagonal, r + 1, n);
            col.remove(i);
            diagonal.remove(r - i);
            rediagonal.remove(r + i);
        }
    }
}