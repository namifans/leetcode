"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        graph_map = {}

        def dfs_traverse(node: Optional['Node']) -> Optional['Node']:
            if node:
                clone_node = Node(node.val)
                graph_map[node] = clone_node
                for n in node.neighbors:
                    clone_node.neighbors.append(graph_map[n]) if n in graph_map else clone_node.neighbors.append(dfs_traverse(n))
                return clone_node

        return dfs_traverse(node)