class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<Integer>(stones.length , (x , y) -> (y - x));
        for (int s : stones) {
            q.add(s);
        }
        while (!q.isEmpty()) {
            int s1 = q.remove();
            if (q.isEmpty())
                return s1;
            int s2 = q.remove();
            if (s1 != s2) {
                q.add(Math.abs(s1 - s2));
            }
        }
        return 0;
    }
}