class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (q.size() > 1) {
            int tmp = k;
            while (tmp > 1) {
                q.add(q.remove());
                tmp--;
            }
            q.remove();
        }
        return q.peek();
    }
}