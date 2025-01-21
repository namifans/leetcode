class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int source = image[sr][sc];
        while (!queue.isEmpty()) {
            int[] c = queue.remove();
            if (image[c[0]][c[1]] == color) {
                continue;
            }
            if (image[c[0]][c[1]] == source) {
                image[c[0]][c[1]] = color;
            }
            for (int i = 0; i < 4; i++) {
                int x = c[0] + dx[i];
                int y = c[1] + dy[i];
                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == source)
                    queue.add(new int[]{x, y}); 
            }
        }
        return image;
 
   }
}