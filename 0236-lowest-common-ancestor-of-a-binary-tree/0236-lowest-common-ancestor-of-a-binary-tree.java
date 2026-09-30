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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q)
            return root;
        boolean pExistsInLeft = exists(root.left, p.val);
        boolean qExistsInLeft = exists(root.left, q.val);
        if (pExistsInLeft != qExistsInLeft)
            return root;
        else if (pExistsInLeft)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }

    private boolean exists(TreeNode root, int value) {
        if (root == null)
            return false;
        if (root.val == value)
            return true;
        return exists(root.left, value) || exists(root.right, value);
    }
}