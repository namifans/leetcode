class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m - 1, top = 0, bot = n - 1;
        int current = -1;
        while (top <= bot) {
            int mid = top + (bot - top) / 2; 
            if (matrix[mid][left] == target || matrix[mid][right] == target) {
                return true;
            } else if (matrix[mid][left] > target) {
                bot = mid - 1;
            } else if (matrix[mid][right] < target) {
                top = mid + 1;
            } else {
                current = mid;
                break;
            }
        } 
        if (current == -1)
            return false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[current][mid] == target) {
                return true;
            } else if (matrix[current][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}