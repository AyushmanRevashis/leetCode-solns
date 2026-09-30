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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        dfs(root, ans);
        if(root==null)return;
        for (int i = 0; i < ans.size()-1; i++) {
            TreeNode a = ans.get(i);
            TreeNode b = ans.get(i + 1);
            a.right = b;
            a.left = null;
        }
        TreeNode last = ans.get(ans.size() - 1);
        last.right = null;
        last.left = null;

    }

    public void dfs(TreeNode root, ArrayList<TreeNode> ans) {
        if (root == null)
            return;
        ans.add(root);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}