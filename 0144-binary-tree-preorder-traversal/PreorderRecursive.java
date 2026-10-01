class Solution {
    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<Integer>();
        dfs(root,ans);
        return ans;
    }
}