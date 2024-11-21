class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int j = 0, k = image[0].length - 1;
            while (j <= k) {
                int t = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = t;
                if (j != k) {
                    image[i][j] ^= 1;
                }
                image[i][k--] ^= 1;
                j++;
            }
        }
        return image;
    }
}