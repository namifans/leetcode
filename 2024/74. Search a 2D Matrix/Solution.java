class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0, b = matrix.length - 1;
        while (t <= b) {
            int m = (b - t) / 2 + t;
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] < target) {
                t = m + 1;
            } else {
                b = m - 1;
            }
        }
        return search(matrix[(t + b) / 2], target);
    }

    private boolean search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (arr[m] == target) {
                return true;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}