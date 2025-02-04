class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int i = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        boolean fifo = true;
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        while (!queue.isEmpty()) {
            List<int[]> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                list.add(queue.remove());
            }
            for (int[] in : list) {
                if (in[1] + 1 < mat[0].length && !visited[in[0]][in[1] + 1]) {
                    queue.offer(new int[]{in[0], in[1] + 1});
                    visited[in[0]][in[1] + 1] = true;
                }
                if (in[0] + 1 < mat.length && !visited[in[0] + 1][in[1]] ) {
                    queue.offer(new int[]{in[0] + 1, in[1]});
                    visited[in[0] + 1][in[1]] = true;
                }
            }
            while (!list.isEmpty()) {
                int[] in;
                if (!fifo) {
                    in = list.removeFirst();
                } else {
                    in = list.removeLast();
                }
                res[i++] = mat[in[0]][in[1]];
            }
            fifo = !fifo;
        }
        return res;
    }
}