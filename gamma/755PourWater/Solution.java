class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int index = K, height = heights[K];
            for (int j = K - 1; j >= 0 && heights[j] <= height; j--) {
                if (heights[j] < height) {
                    height = heights[j];
                    index = j;
                }
            }
            if (index != K) {
                heights[index]++;
                continue;
            }
            for (int j = K + 1; j < heights.length && heights[j] <= height; j++) {
                if (heights[j] < height) {
                    height = heights[j]; 
                    index = j;
                }
            }
            heights[index]++;
        }
        return heights;
    }
}