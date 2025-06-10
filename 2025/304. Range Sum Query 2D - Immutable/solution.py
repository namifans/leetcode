class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        m, n = len(matrix), len(matrix[0])
        self.grid_sum = [[0] * n for _ in range(m)]
        for i in range(m):
            row_sum = 0
            for j in range(n):
                row_sum += matrix[i][j]
                self.grid_sum[i][j] = row_sum
                if i > 0:
                    self.grid_sum[i][j] += self.grid_sum[i - 1][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        
        sum_main = self.grid_sum[row2][col2]
        if col1 > 0:
            sum_main -= self.grid_sum[row2][col1 - 1] # remove left
        if row1 > 0:
            sum_main -= self.grid_sum[row1 - 1][col2] # remove top
        if col1 and row1 > 0:
            sum_main += self.grid_sum[row1 - 1][col1 - 1] # add back overlap top-left
        return sum_main

# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)