class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        INF = 2 ** 31 - 1
        queue = deque()
        for i in range(len(rooms)):
            for j in range(len(rooms[i])):
                if rooms[i][j] == 0:
                    queue.append((i,j,0))

        while queue:
            (i,j,val) = queue.popleft()
            for (x, y) in ((0,1),(1,0),(-1,0),(0,-1)):
                ii, jj = i + x, j + y
                if (0 <= ii < len(rooms) and 
                    0 <= jj < len(rooms[i]) and 
                    rooms[ii][jj] != -1 and 
                    rooms[ii][jj] == INF):
                    rooms[ii][jj] = val + 1
                    queue.append((ii, jj, val+1))