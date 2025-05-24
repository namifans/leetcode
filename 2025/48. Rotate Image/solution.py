class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        # flip 180
        for i in range(n):
            for j in range(n // 2):
                matrix[i][j], matrix[i][n - j - 1] =  matrix[i][n - j - 1], matrix[i][j]
        # swap anti-diagonal
        for i in range(n - 1):
            for j in range(n - i - 1):
                matrix[i][j], matrix[n - j - 1][n - i - 1] = matrix[n - j - 1][n - i - 1], matrix[i][j]