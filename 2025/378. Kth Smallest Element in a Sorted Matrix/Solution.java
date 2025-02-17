class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        int size = matrix.length * matrix[0].length - k + 1;
        for (int[] i : matrix) {
            for (int j : i) {
                heap.offer(j);
                if (heap.size() > size) {
                    heap.remove();
                }
            }
        }
        return heap.peek();
    }
}