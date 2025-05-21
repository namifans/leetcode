class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if n - 1 != len(edges):
            return False

        neighbor_list = [[] for _ in range(n)]
        for origin, dest in edges:
            neighbor_list[origin].append(dest)
            neighbor_list[dest].append(origin)

        visited = set()
        def dfs_traverse(node: int):
            if node in visited: return
            visited.add(node)
            for n in neighbor_list[node]:
                dfs_traverse(n)
        dfs_traverse(0)
        return len(visited) == n
