# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def traverse(root, min_val = -math.inf, max_val = math.inf) -> bool:
            if root is None:
                return True
            if root.val >= max_val or root.val <= min_val:
                return False
            return traverse(root.left, min_val, root.val) and traverse(root.right, root.val, max_val)

        return traverse(root)