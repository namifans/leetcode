# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        if not root:
            return "nil"
        tree = []
        def preorder(root):
            if not root:
                tree.append("nil")
            else:
                tree.append(str(root.val))
                preorder(root.left)
                preorder(root.right)
        preorder(root)
        return ",".join(tree)

    def deserialize(self, data):
        if not data:
            return null
        def dfs():
            val = next(itr)
            if val ==  "nil":
                return None
            root = TreeNode(val)
            root.left = dfs()
            root.right = dfs()
            return root
        itr = iter(data.split(","))
        return dfs()
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))