# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {item: idx for idx, item in enumerate(inorder)}
        index = len(postorder) - 1
        def build(left, right): 
            nonlocal index
            if left > right:
                return
            val = postorder[index]
            index -= 1
            node = TreeNode(val)
            node.right = build(inorder_map[val] + 1, right)
            node.left = build(left, inorder_map[val] - 1)
            return node
            
        return build(0, len(inorder) - 1)