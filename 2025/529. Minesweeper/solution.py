class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        (i, j) = click
        m, n = len(board), len(board[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0),(1,1),(-1,1),(1,-1),(-1,-1)]
        if board[i][j] == 'M': # check bombed
            board[i][j] = 'X'
            return board
        queue = deque()
        queue.append((i,j))
        while queue:
            (i,j) = queue.popleft()
            mines = 0
            if board[i][j] != 'E':
                continue
            for x,y in dirs: # check surrounding bomb
                ii, jj = i + x, j + y
                if 0 <= ii < m and 0 <= jj < n:
                    if board[ii][jj] == 'M':
                        mines += 1
            if mines > 0:
                board[i][j] = str(mines)
            else:
                board[i][j] = 'B'
                for x,y in dirs: # check surrouding if current is not bomb
                    ii, jj = i + x, j + y
                    if 0 <= ii < m and 0 <= jj < n and board[ii][jj] == 'E':
                        queue.append((ii, jj))
        return board