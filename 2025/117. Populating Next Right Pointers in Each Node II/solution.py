"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        queue = deque()
        queue.append(root)
        while queue:
            cur = None
            size = len(queue)
            for _ in range(size):
                if cur == None:
                    cur = queue.popleft()
                else:
                    cur.next = queue.popleft()
                    cur = cur.next
                if cur and cur.left:
                    queue.append(cur.left)
                if cur and cur.right:
                    queue.append(cur.right)
        return root