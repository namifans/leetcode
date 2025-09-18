# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:    
        res, depth = 0, 0
        def getSum(root, d):
            nonlocal res, depth
            if not root:
                return
            if not root.left and not root.right:
                if d > depth:
                    depth = d
                    res = root.val
                elif d == depth:
                    res += root.val
            getSum(root.left, d + 1)
            getSum(root.right, d + 1)
        getSum(root, 1)
        return res