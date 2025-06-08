# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:

        def dfs(root):
            if not root:
                return 0
            height = 0
            if root.left or root.right:
                height = max(dfs(root.left), dfs(root.right)) + 1
                root.left = None
                root.right = None
            if len(res) <= height:
                res.append([])
            res[height].append(root.val)
            return height
   
        res = []
        dfs(root)
        return res

        