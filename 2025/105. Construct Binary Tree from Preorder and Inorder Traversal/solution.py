# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {item: idx for idx, item in enumerate(inorder)}
        index = 0
        
        def build(left, right):
            if left > right:
                return
            nonlocal index
            val = preorder[index]
            index += 1
            node = TreeNode(val)
            node.left = build(left, inorder_map[val] - 1)
            node.right = build(inorder_map[val] + 1, right)
            return node
        
        return build(0, len(preorder) - 1)