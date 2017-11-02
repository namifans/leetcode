/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack = new Stack();
    public BSTIterator(TreeNode root) {
        stackPush(root);
    }

    private void stackPush(TreeNode root) {
        if (root == null)
            return;
        if (!stack.empty() && root == stack.peek())
            return;
        stack.push(root);
        stackPush(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        if (current != null) {
            if (current.right != null) {
                stackPush(current.right);
            } 
            return current.val;
        }
        return -1;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */