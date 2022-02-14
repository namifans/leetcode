class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int org = image[sr][sc];
        floodFill(image, org, sr, sc, newColor);
        return image;
    }
    private void floodFill(int[][] image, int org, int i, int j, int newColor) {
        if (image[i][j] == newColor)
            return;
        if (image[i][j] == org)
            image[i][j] = newColor;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < image.length && nj >=0 && nj < image[0].length 
                && image[ni][nj] == org && image[ni][nj] != newColor) {
                floodFill(image, org, ni, nj, newColor);
            }
        }
    }
}
