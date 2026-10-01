class Solution {
    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        dfs(root, ans);
        return ans;
    }
}