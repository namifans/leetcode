class Solution {
    public void rotate(int[][] matrix) {
        int top = 0, bot = matrix.length - 1;
        while (top < bot) {
            int[] tmp = matrix[top];
            matrix[top++] = matrix[bot];
            matrix[bot--] = tmp;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}

/*
rotate clockwise
 swap top -> bot
 swap symmetric
 
rotate counter clockwise
 swap left -> right
 wap symmetric
*/