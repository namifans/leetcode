# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res = []
        queue = deque([root])
        while queue:
            size = len(queue)
            q = []
            for _ in range(size):
                n = queue.popleft()
                if n.left:
                    queue.append(n.left)
                if n.right:
                    queue.append(n.right)
                q.append(n.val)
            res.append(q)
        return res