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
        tree = str(root.val) + ","
        tree += self.serialize(root.left) + ","
        tree += self.serialize(root.right)
        return tree
        

    def deserialize(self, data):
        if not data:
            return null
        tree = data.split(",")
        
        def dfs():
            root = None
            if tree:
                val = tree.pop(0)
                if val ==  "nil":
                    return None
                root = TreeNode(val)
            if root:
                root.left = dfs()
                root.right = dfs()
            return root

        return dfs()
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))