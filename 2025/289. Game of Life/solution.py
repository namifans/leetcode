class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m, n = len(board), len(board[0])
        directions = [(0,1),(0,-1),(1,0),(-1,0),(1,1),(-1,-1),(-1,1),(1,-1)]
        for i in range(m):
            for j in range(n):
                neighbor = 0
                for x,y in directions:
                    ni, nj = i + x, j + y
                    if (0 <= ni < m and 
                        0 <= nj < n and 
                        abs(board[ni][nj]) == 1):
                        neighbor += 1
                if board[i][j] == 1:
                    if neighbor < 2 or neighbor > 3:
                        board[i][j] = -1
                elif neighbor == 3:
                    board[i][j] = 2

        for i in range(m):
            for j in range(n):  
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1