class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int[] pt = queue.remove();
            int i = pt[0], j = pt[1];
            list.add(nums.get(i).get(j));
            if (j == 0 && i + 1 < nums.size()) {
                queue.add(new int[]{i + 1, j});
            }
            if (j + 1 < nums.get(i).size()) {
                queue.add(new int[]{i, j + 1});
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}