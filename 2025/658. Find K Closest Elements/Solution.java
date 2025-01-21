class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] == y[0]) {
                    return x[1] - y[1];
                } else {
                    return x[0] - y[0];
                }
            }
        });   
        List<Integer> res = new ArrayList<>();
        for (int i : arr) {
            heap.add(new int[]{Math.abs(i - x), i});
        }
        while (!heap.isEmpty() & k > 0) {
            int[] t = heap.remove();
            res.add(t[1]);
            k--;
        }
        Collections.sort(res);
        return res;
    }
}