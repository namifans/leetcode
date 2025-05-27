class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        visited = [[False for _ in range(len(board[0]))] for _ in range(len(board))]

        def dfs(idx: int, i: int, j: int) -> bool:
            if idx >= len(word) or board[i][j] != word[idx]:
                return False
            if idx == len(word) - 1:
                return True
            visited[i][j] = True
            found = False
            for (x, y) in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                ii, jj = i + x, j + y
                if (ii >= 0 and jj >= 0 
                    and ii < len(board) and jj < len(board[0]) 
                    and not visited[ii][jj]):
                    found |= dfs(idx + 1, ii, jj)
            visited[i][j] = False
            return found

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0] and dfs(0, i, j):
                    return True
        return False