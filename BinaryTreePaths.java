class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> arr, List<String> ans) {
        if (root == null) return;

        arr.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                if (i > 0) sb.append("->");
                sb.append(arr.get(i));
            }
            ans.add(sb.toString());
        }
            dfs(root.left, arr, ans);
            dfs(root.right, arr, ans);
            arr.remove(arr.size() - 1); 
    }
}