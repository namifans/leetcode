class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int mi = mid / n, mj = mid % n;
            if (matrix[mi][mj] == target) {
                return true;
            } else if (matrix[mi][mj] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}