/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = null;
        int num = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '-': {
                    sign = -1;
                } break;
                case '(': {
                    TreeNode node = current != null ? current : new TreeNode(sign * num);
                    stack.push(node);
                    num = 0;
                    sign = 1;
                    current = null;
                } break;
                case ')': {
                    TreeNode node = current != null ? current : new TreeNode(sign * num);
                    TreeNode parent = stack.pop();
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                    current = parent;
                    num = 0;
                    sign = 1;
                } break;
                default: {
                    num = num * 10;
                    num += c - '0';
                }
            }
        }
        return current == null ? new TreeNode(sign * num) : current;
    }
}