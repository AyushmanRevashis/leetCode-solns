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
    static int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        levels(root);
        return max;
    }

    int levels(TreeNode root) {
        if(root==null)return 0;
        int lfLevels = levels(root.left);
        int rtLevels = levels(root.right);
        max = Math.max(max, lfLevels+ rtLevels);
        return 1 + Math.max(lfLevels, rtLevels);
    }
}