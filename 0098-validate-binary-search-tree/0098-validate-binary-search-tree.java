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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ans.get(i) >= ans.get(j)) {
                    return false;
                }
            }
        }return true;

    }

    public void inorder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}