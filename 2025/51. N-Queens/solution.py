class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [["."] * n for _ in range(n)]
        col_set, dia_set, anti_set = set(), set(), set()
       
        def backtrack(row, board):
            if row == n:
                tmp = []
                for b in board:
                    s = "".join(b)
                    tmp.append(s) 
                res.append(tmp)
                return   
            for col in range(n):
                if (col in col_set or 
                (col - row) in dia_set or
                (row + col) in anti_set):
                    continue
                board[row][col] = 'Q'
                col_set.add(col)
                dia_set.add(col - row)
                anti_set.add(col + row)
                backtrack(row + 1, board)
                board[row][col] = '.'
                col_set.remove(col)
                dia_set.remove(col - row)
                anti_set.remove(col + row)

        backtrack(0, board)
        return res