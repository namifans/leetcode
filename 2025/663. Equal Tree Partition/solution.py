# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkEqualTree(self, root: Optional[TreeNode]) -> bool:
        sum_list = []
        def dfs(root):
            if not root:
                return 0
            val_sum = root.val
            val_sum += dfs(root.left) + dfs(root.right)
            sum_list.append(val_sum)
            return val_sum
        root_sum = dfs(root)
        if root_sum % 2 != 0:
            return False
        sum_list.pop()
        for v in sum_list:
            if v == root_sum // 2:
                return True
        return False