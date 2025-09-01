# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res, queue = [], deque([root])
        odd_lvl = True
        while queue:
            level = deque()
            for _ in range(len(queue)):
                node = queue.popleft()
                if odd_lvl:
                    level.append(node.val)
                else:
                    level.appendleft(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(list(level))
            odd_lvl = not odd_lvl
        return res