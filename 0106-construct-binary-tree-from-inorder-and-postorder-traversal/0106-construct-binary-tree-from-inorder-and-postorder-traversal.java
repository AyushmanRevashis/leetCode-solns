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
    public TreeNode buildTree( int[] inorder,int[] postorder) {
        int n = inorder.length;
        return build(0, n - 1, 0, n - 1, postorder, inorder);
    }

    public TreeNode build(int poLo, int poHi, int inLo, int inHi, int[] postorder, int[] inorder) {
        if (poLo > poHi)
            return null;
        int val = postorder[poHi];
        TreeNode root = new TreeNode(val);
        int r = 0;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == val) {
                r = i;
                break;
            }
        }
        int count = r - inLo;
        root.left = build(poLo, poLo + count-1, inLo, r-1 , postorder, inorder);
        root.right = build(poLo + count , poHi-1, r + 1, inHi, postorder, inorder);
        return root;
    }
}