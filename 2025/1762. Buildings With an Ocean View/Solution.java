class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> buildings = new ArrayList<>();
        int maxHeight = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                buildings.add(i);
                maxHeight = heights[i];
            }
        }
        int[] res = new int[buildings.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = buildings.get(buildings.size() - i - 1);
        }
        return res;
    }
}