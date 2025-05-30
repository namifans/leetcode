# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_sum = -float("inf")
        def findSum(root):
            nonlocal max_sum
            cur_sum = 0
            if root:
                left_sum = findSum(root.left)
                right_sum = findSum(root.right)
                cur_sum = max(root.val, root.val + left_sum, root.val + right_sum)
                max_sum = max(max_sum, cur_sum, root.val + left_sum + right_sum)
            return cur_sum
        findSum(root)
        return max_sum