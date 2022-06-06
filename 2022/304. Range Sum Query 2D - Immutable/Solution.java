class NumMatrix {
    
    int[][] rowSum;
    
    public NumMatrix(int[][] matrix) {
        rowSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            rowSum[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                rowSum[i][j] = matrix[i][j] + rowSum[i][j - 1]; 
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += rowSum[i][col2];
            if (col1 >= 1)
                sum -= rowSum[i][col1 - 1];
        }
        return sum;        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */