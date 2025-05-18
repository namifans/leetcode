# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        def serialize(root: Optional[TreeNode]) -> str:
            if root:
                s = (f"#{str(root.val)}" 
                    f"{serialize(root.left)}" 
                    f"{serialize(root.right)}")
                return s
            else:
                return "#nil"

        return serialize(subRoot) in serialize(root)