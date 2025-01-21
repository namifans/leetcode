// [[1,2,3],[0,2],[0,1,3],[0,2]]

// [1,2,3]
// [0,2]
// [0,1,3]
// [0,2]

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, 1, i))
                return false;
        }
        return true; 
    }

    private boolean dfs(int[][] graph, int[] colors, int color, int index) {
        colors[index] = color;
        for (int i : graph[index]) {
            if (colors[i] == color)
                return false;
            if (colors[i] == 0 && !dfs(graph, colors, -color, i))
                return false;
        }
        return true;
    }
}