class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        k, m, n = 0, len(matrix), len(matrix[0])
        res, visited, queue = [], set(), deque([(0,0)])
        while len(res) < m * n:
            i, j = queue.popleft()
            res.append(matrix[i][j])
            visited.add((i, j))
            x, y = i + dir[k][0], j + dir[k][1]
            if (x < 0 or y < 0 or x >= m or y >= n or (x, y) in visited):
                k = (k + 1) % 4
            x, y = i + dir[k][0], j + dir[k][1]
            queue.append((x, y))
        return res