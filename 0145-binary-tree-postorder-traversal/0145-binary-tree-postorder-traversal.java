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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> q = new Stack<>();
        if (root == null)
            return ans;
        q.push(root);
        while (q.size() > 0) {
            TreeNode top = q.pop();
            ans.add(top.val);
            if (top.left != null)
                q.push(top.left);
            if (top.right != null)
                q.push(top.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}