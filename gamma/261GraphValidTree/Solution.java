class Solution {

    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (n < 2) {
            return true;
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int r1 = find(edges[i][0]);
            int r2 = find(edges[i][1]);
            if (r1 == r2) {
                return false;
            }
            parent[r1] = r2;
        }
        return edges.length == n - 1;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}