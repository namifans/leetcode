class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        matrix = [[0] * n for _ in range(n)]
        direction = [(0,1),(1,0),(0,-1),(-1,0)]
        i = j = k = 0
        count = 1
        while count <= n * n:
            matrix[i][j] = count
            count += 1
            ni, nj = i + direction[k][0], j + direction[k][1]
            if (ni < 0 or nj < 0 or
                ni >= n or nj >= n or
                matrix[ni][nj] != 0):
                k = (k + 1) % 4
                next_move = direction[k]
            i, j = i + direction[k][0], j + direction[k][1]
        return matrix