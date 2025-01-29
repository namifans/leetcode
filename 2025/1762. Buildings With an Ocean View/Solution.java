class Solution {
    public int[] findBuildings(int[] heights) {
        int highest = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > highest) {
                list.add(i);
            }
            highest = Math.max(highest, heights[i]);
        }
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            res[i] = list.get(list.size() - i - 1);
        }
        return res;
    }
}