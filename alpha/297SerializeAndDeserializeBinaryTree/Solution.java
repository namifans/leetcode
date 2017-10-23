/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        StringBuilder sb = new StringBuilder();
        treeToString(root, sb);
        return sb.toString();
    }

    private void treeToString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        treeToString(root.left, sb);
        treeToString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return stringToTree(queue);
    }

    private TreeNode stringToTree (Queue<String> queue) {
        String s = queue.poll();
        if ("#".equals(s)) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(s));
        newNode.left = stringToTree(queue);
        newNode.right = stringToTree(queue);
        return newNode;
    } 
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));