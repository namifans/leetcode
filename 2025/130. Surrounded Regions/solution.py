class Solution:
    def solve(self, board: List[List[str]]) -> None:

        def dfs(board, i, j):
            board[i][j] = '-'
            for (x,y) in ((1,0),(0,1),(-1,0),(0,-1)):
                ii, jj = i + x, j + y
                if (0 <= ii < len(board) and
                    0 <= jj < len(board[0]) and
                    board[ii][jj] == 'O'):
                    dfs(board, ii, jj)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if (i == 0 or j == 0 or i == len(board) - 1 or j == len(board[0]) - 1) and board[i][j] == 'O':
                    dfs(board,i,j)
       
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '-':
                    board[i][j] = 'O'