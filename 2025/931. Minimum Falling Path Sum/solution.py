class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        for i in range(1, m):
            for j in range(n):
                left = right = mid = float('inf')
                if 0 < j:
                    left = matrix[i - 1][j - 1]
                if j < n - 1:
                    right = matrix[i - 1][j + 1]
                mid = matrix[i - 1][j]
                matrix[i][j] = min(left, right, mid) + matrix[i][j]
        return min(matrix[m - 1])