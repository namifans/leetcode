class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> heap = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] i, int[] j) {
                if (i[1] != j[1])
                    return i[1] - j[1];
                else 
                    return j[0] - i[0];
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> l = nums.get(i);
            for (int j = 0; j < l.size(); j++) {
                heap.add(new int[] {i, (i + j), l.get(j)});
            }
        }
        int[] res = new int[heap.size()];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.remove()[2];
        }
        return res;
    }
}