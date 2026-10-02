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
    public TreeNode convertBST(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        inorder(root, ans);
        Collections.reverse(ans);
        int sum = 0;
        for (int i = 0; i < ans.size(); i++) {
            ans.get(i).val += sum;
            sum = ans.get(i).val;
        }
        Collections.reverse(ans);
        return root;
    }

    public void inorder(TreeNode root, ArrayList<TreeNode> ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        ans.add(root);
        inorder(root.right, ans);
    }
}