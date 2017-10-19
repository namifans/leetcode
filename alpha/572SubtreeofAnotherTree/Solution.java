/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sStr = treeToString(s);
        String tStr = treeToString(t);
        return sStr.contains(tStr);
    }

    private String treeToString(TreeNode r) {
        if (r == null) {
            return " null";
        }
        StringBuilder sb = new StringBuilder();
        if (r.left == null)
            sb.append(" lnull");
        else
            sb.append(treeToString(r.left));
        sb.append(" " + r.val);
        if (r.right == null)
            sb.append(" rnull");
        else
            sb.append(treeToString(r.right));
        return sb.toString();
    }
}