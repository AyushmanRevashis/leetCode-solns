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
    static int s;

    public boolean isCompleteTree(TreeNode root) {
        s = size(root);
        return isCBT(root, 1);

    }

    private boolean isCBT(TreeNode root, int idx) {
        if (root == null)
            return true;
        if (s < idx)
            return false;
        return (isCBT(root.left, 2 * idx) && isCBT(root.right, 2 * idx + 1));
    }

    private int size(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }
}